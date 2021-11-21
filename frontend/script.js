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
    
    //if((!paciente.nome)||(!paciente.cpf) || (!paciente.altura)) {
     //   alert(`Campos vazios `)
    //    return
       
   // }


    //vamos criar a conexão

    let requisicao = new XMLHttpRequest()
    //abre a conexão com o verbo "POST"
    //true indica que a abertura de conexão é assíncrona
    requisicao.open('POST', 'http://localhost:8090/paciente', true)

    //configura o cabeçaho da requisição
    requisicao.setRequestHeader("Content-Type", "application/json")

    //converter json em string para enviar estes dados
    requisicao.send(JSON.stringify(paciente))
    alert('Paciene foi inserido com sucesso')
}
let remover = (id) => {
    let req = new XMLHttpRequest()
    let resp = confirm('Confirma exclusão do paciente')
    if(resp) {
    req.open('DELETE', `http://localhost:8090/paciente/${id}`, true)
    req.send()
    alert(`Paciente removido com sucesso`)
    preencherTabela()
    }
}
let preencherTabela = () => {
    //criar conexao para chamada de api
    let req = new XMLHttpRequest()
    req.open('GET', 'http://localhost:8090/paciente', true)
    req.onload = function(){
        //recuper os dados da API - converte string em JSON
        let pacientes = JSON.parse(this.response)
        //percorrer os pacientes
        let conteudo=""
        pacientes.map(paciente => {
            conteudo = conteudo + `<tr> <td>${paciente.nome}</td> <td>${paciente.cpf}</td> <td>${paciente.altura}</td> <td>${paciente.peso}</td> <td>${paciente.idade}</td> <td> <button onClick="remover(${    paciente.id})"> <i class="bi bi-archive-fill"></i> </button> </td>  <td> <button> <i class="bi bi-pencil-fill"></i> </button> </td></tr>`

        })
        document.getElementById("conteudoTabela").innerHTML = conteudo
    }
    req.send()
  
        //monta a saída de dados
        
}