# teste-sccloud

Olá!  
## Requisitos para rodar o projeto


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
