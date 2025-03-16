package com.victot.SCClouds_Test.services;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CacheService {

    private final Map<Integer, BigInteger> fibonacciCache = new ConcurrentHashMap<>();
    private final Map<Integer, Boolean> primesCache = new ConcurrentHashMap<>();

    public BigInteger getFibonacci(int n) {
        return fibonacciCache.get(n);
    }

    public void putFibonacci(int n, BigInteger value) {
        fibonacciCache.put(n, value);
    }

    public Boolean isPrimeCached(int n) {
        return primesCache.get(n);
    }

    public void putPrime(int n, boolean isPrime) {
        primesCache.put(n, isPrime);
    }

//    public boolean isPrimo(int n){
//        if(n < 2)
//            return false;
//
//        for(int i = 2; i <= Math.sqrt(n); i++){
//            if(n % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}
