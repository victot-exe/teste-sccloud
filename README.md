# teste-sccloud

Olá!  
Este é um repositório com o teste técnico da SC Cloud resolvido por mim :)

## Requisitos para rodar o projeto

1. Faça o clone deste repositório:  
_Precisa ter o git instalado no computador para que o comando execute_
~~~bash
git clone https://github.com/victot-exe/teste-sccloud.git
~~~


### 1ª Maneira
**A maneira mais simples de rodar este projeto é através do docker, você precisa ter o docker e o docker-compose devidamente instalados e configurados;**  
**Importante**: ter a porta 8081 e a 8082 livres no seu computador para que a aplicação funcione corretamente;
1. Abra o terminal da raiz do projeto e digite:
~~~bash
docker-compose build
~~~
2. Após o build encerrar escreva o comando
~~~bash
docker-compose up -d
~~~
2. Caso prefira que mostre o log de inicialização digite o comando:
~~~bash
docker-compose up
~~~

### 2ª Maneira

**Esta maneira é bem mais "complicada" mas também funciona**  
**Você precisa do Java >= 21 instalado e o gradle >= **
1. Para facilitar utilize a IDE de sua preferência, eu utilizei o InteliJ
2. De o run no projeto na classe `...\SCClouds-Test\SCClouds-Test\src\main\java\com\victot\SCClouds_Test\ScCloudsTestApplication.java`
3. Após a aplicação iniciar abra o arquivo em `...\Front-end\index.html` | se preferir inicie o mesmo com o live-server no vsCode

*Caso você altere alguma configuração de portas do backend será necessário definir a nova porta no arquivo`...\Front-end\script.js`, nas funções `calcularFibonacci()` e `calcularPrimos()`*

## Explicando a resolução.
Para a realização das funções preferi criar uma API com Spring Boot para poder demonstrar mais meus conhecimentos, e consumir a mesma em uma página web simples, utilizando tecnologias básicas como html (usei o bootstrap para facilitar a organização).  
Na API eu desenvolvi os services para resolverem os problemas propostos. 
#### Fibonacci
A sequência de Fibonacci, bem simples de se olhar onde inicialmente temos 0, 1 ..., somamos os dois últimos números para obter o próximo completando a sequência.  `0+1=1 ; 1+1=2; ...` e por aí vai.  
Foi bem mais simples resolve-la de maneira linear, com um for e uma array, onde retornamos o último elemento da mesma. Escolhi o retorno como BigInteger para poder abranger uma quantidade maior de resultados e com mais precisão.  
Já o modo recursivo me deu um pouco mais de trabalho, onde eu tive que decifrar os casos base da equação, zero e um, e a fórmula: `n=(n-1)+(n-2)`. Eu utilizei um sistema de cache para diminuir o processamento necessário, pois para calcular números baixos já seria necessário fazer o mesmo cálculo muitas vezes, utilizei o Map, para guardar Key=n e Valeu=Fibonacci(n), dessa forma só será necessário calcular cada n uma única vez, conseguindo uma performance bem maior do que sem o cachê. 
#### Números primos
Números primos são os números que são >= 2, divisíveis apenas por 1 e por eles mesmos.  
De forma linear com um for percorrendo os números menores do que n e adicionando a lista todos os que atendem a condição (para utilizar a reutilização de código aqui eu criei uma função que verifica se o número é primo, utilizando a mesma tanto no modo linear quanto no recursivo).  
No modo recursivo (neste a utilização do cachê não se fez tão necessária, mas utilizei mesmo assim), utilizei o polimorfismo, tendo a função `primosAteNRecursive(int n)` que ao final chama `primosAteNRecursive(int n, List<Integer> primes)` que ao final vai chamando ela mesma até que o n seja > 2 para retornar os números primos, para a primeira função que inverte a Lista e retorna o resultado desejado.  
Nesta eu utilizei Integer pois se tratando de números primos é mais difícil de chegar em um número tão grande quanto calculando o Fibonacci.  
#### Front-end
No front-end eu respondi as perguntas utilizando cards como se fossem tópicos de uma página comum contando sobre um assunto, deixando ao final da página dois cards que chamam e consomem a API através do GET, e criam elementos para compor as linhas de uma tabela, cada função tem a sua tabela, onde detalha o n, qual ou quais os números gerados, e se eles foram gerados de maneira linear ou recursiva.

## Agradecimentos
Agradeço pela oportunidade, pude aprender mais e me desafiar neste exercício proposto.