# CURSO DE SRING REST PARA INICIANTES

Tópicos Abordados:
   - Introdução ao REST
   - Fundamentos do REST
   - Primeiras consultas e cadastros na API
   - Atualização e remoção de recursos na API
   - Relacionamentos entre recursos REST
   
Endpoinst Disponibilizados para Teste e Exemplos de Massa de Dados:

#### Clientes

1. <a https://my-osworks-api.herokuapp.com/clientes">Cadastrar</a> ** POST **
	```
	{
	  "nome" : "Usuário Heroku",
	  "email" : "usuario.heroku@mail.com",
	  "telefone" : "00 000000000"
	}
	```

2. <a https://my-osworks-api.herokuapp.com/clientes">Listar Todos</a> ** GET **

3. <a https://my-osworks-api.herokuapp.com/clientes/1">Buscar por Id</a> ** GET **

4. <a https://my-osworks-api.herokuapp.com/clientes/1">Atualizar</a> ** PUT **
	```
	{
	  "nome" : "Usuário Heroku Atualizado",
	  "email" : "usuario.heroku.atualizado@mail.com",
	  "telefone" : "11 111111111"
	}
	```
5. <a https://my-osworks-api.herokuapp.com/clientes/1">Excluir</a> ** DELETE **

#### Ordens de Serviço

1. <a https://my-osworks-api.herokuapp.com/ordens-servico">Cadastrar</a> ** POST **
	```
	{
  		"cliente" : {
    	"id" : 1
  	},
  		"descricao" : "Celular Samsung com tela quebrada.",
  		"preco" : 600.00
	}
	```

2. <a https://my-osworks-api.herokuapp.com/ordens-servico">Listar Todas</a> ** GET **

3. <a https://my-osworks-api.herokuapp.com/ordens-servico/1">Buscar por Id</a> ** GET **

4. <a https://my-osworks-api.herokuapp.com/ordens-servico/1/finalizacao">Finalizar</a> ** PUT **

#### Comentários

1. <a https://my-osworks-api.herokuapp.com/ordens-servico/11/comentarios">Cadastrar</a> ** POST **
	```
	{
		"descricao" : "Tela do celular trocada com sucesso"
	}
	```
	
2. <a https://my-osworks-api.herokuapp.com/ordens-servico/11/comentarios">Listar</a> ** GET **

 

