package com.victot.SCClouds_Test.services;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@Service
public class QuestionsService {

    public final CacheService cacheService;

    public QuestionsService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    public BigInteger fibonacciLinear(int n){
        if(n < 0)
            throw new IllegalArgumentException("O número deve ser maior ou igual a zero");
        if(n == 0) return BigInteger.ZERO;

        List<BigInteger> fibonacci = new ArrayList<>();
        fibonacci.add(BigInteger.ZERO);
        fibonacci.add(BigInteger.ONE);

        for(int i = 2; i <= n; i++){
            fibonacci.add(fibonacci.get(i - 1).add(fibonacci.get(i - 2)));
        }
        return fibonacci.getLast();
    }

    public BigInteger fibonacciRecursive(int n){
        if(cacheService.getFibonacci(n) != null)
            return cacheService.getFibonacci(n);

        BigInteger result = generateFibonacciRecursive(n);
        cacheService.putFibonacci(n, result);
        return result;
    }

    private BigInteger generateFibonacciRecursive(int n){
        if(n < 0)
            throw new IllegalArgumentException("O numero deve ser maior ou igual a ZERO");

        if(cacheService.getFibonacci(n) != null)
            return cacheService.getFibonacci(n);

        if(n == 0) return BigInteger.ZERO;
        if(n == 1) return BigInteger.ONE;

        return fibonacciRecursive(n - 1).add(fibonacciRecursive(n - 2));
    }

    public boolean isPrimo(int n){
        if(n < 2)
            return false;

        if(cacheService.isPrimeCached(n) != null){
            return cacheService.isPrimeCached(n);
        }

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) {
                cacheService.putPrime(n, false);
                return false;
            }
        }

        cacheService.putPrime(n, true);
        return true;
    }

    public List<Integer> primosAteNLinear(int n){
        List<Integer> primes = new ArrayList<>();

        for(int i = 2; i <= n; i++){
            if(isPrimo(i)){
                primes.add(i);
            }
        }
        return primes;
    }

    public List<Integer> primosAteNRecursive(int n){
        List<Integer> primes = new ArrayList<>();

        return primosAteNRecursive(n, primes).reversed();
    }

    private List<Integer> primosAteNRecursive(int n, List<Integer> primes){
        if(n < 2)
            return primes;

        if(isPrimo(n)){
            primes.add(n);
        }
        return primosAteNRecursive(n - 1, primes);
    }
}
