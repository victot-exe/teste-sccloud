console.log("Olá!")

function calcularFibonacci() {
    let nFibonacci = document.getElementById('nFibonacci').value;
    let modoCalculo = document.getElementById('modoDeCalculoFibonacci').value;

    if(nFibonacci == "" || nFibonacci === null ||nFibonacci < 0){
        alert("Insira um valor válido (n >= 0)");
        return;
    }

    if(modoCalculo == "Modo de calculo"){
        alert("Escolha um modo de calculo Linear ou Recursivo");
        return;
    }

    let url = "http://localhost:8080/fibonacci?n=" + nFibonacci + "&type=" + modoCalculo.toUpperCase();

    
    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro na requisição: " + response.status);
            }
            return response.text();
        })
        .then(data => {
            console.log("Resposta:", data);
            inserirElementInTable("table-fibonacci", nFibonacci,data, modoCalculo);
            return data;
        })
        .catch(error => {
            console.error("Erro ao fazer a requisição:", error);
        });
}

function inserirElementInTable(table, n, data, mode){
    let tabelaBody = document.getElementById(table);
    let novaLinha = tabelaBody.insertRow();

    let celulaN = novaLinha.insertCell(0);
    let celulaData = novaLinha.insertCell(1);
    let modoCalculo = novaLinha.insertCell(2);

    celulaN.innerText = n;
    celulaData.innerText = data;
    modoCalculo.innerText = mode;

    celulaData.style.wordWrap = 'break-word';
    celulaData.style.wordBreak = 'break-all'; 
}

function calcularPrimos(){
    let nPrimos = document.getElementById('nPrimos').value;
    let modoCalculo = document.getElementById('modoDeCalculoPrimos').value;

    let url = "http://localhost:8080/prime-numbers?n=" + nPrimos + "&type=" + modoCalculo.toUpperCase();

    if(nPrimos == "" || nPrimos === null ||nPrimos < 2){
        alert("Insira um valor válido (n > 1)");
        return;
    }

    if(modoCalculo == "Modo de calculo"){
        alert("Escolha um modo de calculo Linear ou Recursivo");
        return;
    }
    
    
    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro na requisição: " + response.status);
            }
            return response.text();
        })
        .then(data => {
            console.log("Resposta:", data);
            inserirElementInTable("table-primes", nPrimos ,data, modoCalculo);
            return data;
        })
        .catch(error => {
            console.error("Erro ao fazer a requisição:", error);
        });
}