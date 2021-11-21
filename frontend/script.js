// criar função cadastrar

let cadastrar = () => {
    //recuperar os dados do usuario e já cria o objeto
    // vamos utilizar programação DOM (document object model)
    let paciente ={
        nome: document.getElementById("nome").value,
        cpf: document.getElementById("cpf").value,
        altura: Number(document.getElementById("altura").value),
        peso: Number(document.getElementById("peso").value),
        idade: Number(document.getElementById("idade").value),
    }

    //vamos criar a conexão

    let requisicao = new XMLHttpRequest()
    //abre a conexão com o verbo "POST"
    //true indica que a abertura de conexão é assíncrona
    requisicao.open('POST', 'http://localhost:8080/paciente', true)

    //configura o cabeçaho da requisição
    requisicao.setRequestHeader("Content-Type", "application/json")

    //converter json em string para enviar estes dados
    requisicao.send(JSON.stringify(paciente))
    alert('Paciene foi inserido com sucesso')
}