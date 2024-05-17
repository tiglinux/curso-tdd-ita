# Curso_ITA_TDD
<hr>
#SEMANA_1
<hr>
Criar utilizando TDD um método que transforma uma cadeia de caracteres em camel case (
http://pt.wikipedia.org/wiki/CamelCase)
 em uma lista de Strings com as palavras. O método deve possuir a seguinte assinatura: "public static List<String> converterCamelCase(String original)". 

Faça um relatório detalhando todo o processo de TDD.

Para cada ciclo que você fizer no TDD, adicione uma seção no relatório o seguinte: o teste adicionado, como estava o código antes, como ficou o código depois para fazer o teste passar e uma pequena descrição textual do que foi feito.  

Abaixo seguem alguns exemplos de entrada e saída que você pode usar como base para os seus testes (crie adicionais ou diferentes se achar necessário):

nome - “nome” 

Nome - “nome” 

nomeComposto - “nome”, “composto” 

NomeComposto - “nome”, “composto” 

CPF - “CPF” 

numeroCPF - “numero”, “CPF” 

numeroCPFContribuinte - “numero”, “CPF”, “contribuinte” 

recupera10Primeiros - “recupera”, “10”, “primeiros” 

10Primeiros - Inválido → não deve começar com números 

nome#Composto - Inválido → caracteres especiais não são permitidos, somente letras e números

É permitida a criação de métodos auxiliares. Para ficar mais divertido e praticar a refatoração, nenhum método pode possuir mais de dez linhas de código em seu corpo. Não vale “roubar” e incluir vários comandos em uma mesma linha de código!

Para cada refatoração que precisar fazer nesse processo, adicione uma seção no relatório o seguinte: como estava o código antes, como ficou o código depois da refatoração e uma pequena descrição textual do que foi feito.

No método desenvolvido é permitida somente a utilização de classes da API básica da linguagem Java. Se você utilizar algum componente externo que facilite demais sua tarefa, estará tirando o propósito do exercício!

Você deverá entregar o relatório detalhado e o código final.
<hr>
#SEMANA_2
<hr>
No Curso 1, nós projetamos um conjunto de classes, usando a Modelagem CRC, para o SAB – Sistema de Automação de Biblioteca. A maioria dos métodos implementados precisa de refatoração, que não foi feita para podermos usar algum deles como exercício de revisão por pares.

Assim solicitamos que examine o método abaixo registraUsuario(String) e faça o seguinte:

a) Identifique uma lista de maus cheiros que você encontra no código, relacionando cada um deles com o correspondente tipo de mau cheiro exercitado nesta parte do curso: [mau cheiro no código (trecho do código)/tipo de mau cheiro (de acordo com Fowler, pode estar em português)].

b) Realize o Ciclo de Refatoração apresentado, eliminando cada um dos maus cheiros encontrado no código do método, considerando apenas os tipos de mau cheiro exercitados nesta Semana 2 do curso.

c) Entregue um documento em que você apresenta o seguinte:

A) Código anterior do método registraUsuario(String), antes de iniciar o Ciclo de Refatoração.

B)  Imagem: Imagem da execução bem-sucedida (verde) no Eclipse ou outro ambiente Java, comprovando que código atual do SAB, incluindo o método registraUsuario(String) está funcionando direito (pelo menos de acordo com a bateria de testes atual).

C) Ciclo de Refatoração até a Lista de Maus Cheiros ficar vazia, apresentando 5 coisas para cada refatoração realizada no Ciclo de Refatoração:

Antes: O código Antes da refatoração, com o trecho a ser refatorado com as letras coloridas ou com fundo amarelo

Tipo Mau Cheiro/Técnica de Refatoração: Indique o tipo do mau cheiro identificado no código em 1) e a técnica de refatoração empregada, ambos de acordo com Fowler e podendo estar em português!

Depois: O código Depois da refatoração, com o trecho refatorado com as letras coloridas ou com fundo verde

Imagem: Imagem da execução bem-sucedida (verde) no Eclipse ou outro ambiente Java, comprovando que a refatoração foi feita a contento!

Lista de maus cheiros: Atualize a lista, eliminando o mau cheiro que deu origem à refatoração deste ciclo

D) Código Depois final do método abaixo registraUsuario(String), sem letras ou fundo coloridos!

Procure apresentar o código sempre bem apresentado, de acordo com boas práticas de apresentação/formatação de código Java. Pode usar, por exemplo, o Source/Format do Eclipse ou equivalente do seu ambiente Java.

A bateria de testes atual não pode ser modificada de forma alguma durante o Ciclo de Refatoração!

<hr>
#SEMANA_3
<hr>

Criar, utilizando TDD, uma classe chamada CaixaEletronico, juntamente com a classe ContaCorrente, que possuem os requisitos abaixo:

A classe CaixaEletronico possui os métodos logar(), sacar(), depositar() e saldo() e todas retornam uma String com a mensagem que será exibida na tela do caixa eletrônico.

Existe uma classe chamada ContaCorrente que possui as informações da conta necessárias para executar as funcionalidades do CaixaEletronico. Essa classe faz parte da implementação e deve ser definida durante a sessão de TDD.

As informações da classe ContaCorrente podem ser obtidas utilizando os métodos de uma interface chamada ServicoRemoto. Essa interface possui o método recuperarConta() que recupera uma conta baseada no seu número e o método persistirConta() que grava alterações, como uma mudança no saldo devido a um saque ou depósito. Não tem nenhuma implementação disponível da interface ServicoRemoto e deve ser utilizado um Mock Object para ela durante os testes.

O método persistirConta() da interface ServicoRemoto deve ser chamado apenas no caso de ser feito algum saque ou depósito com sucesso.

Ao executar o método saldo(), a mensagem retornada deve ser "O saldo é R$xx,xx" com o valor do saldo.

Ao executar o método sacar(), e a execução for com sucesso, deve retornar a mensagem "Retire seu dinheiro". Se o valor sacado for maior que o saldo da conta, a classe CaixaEletronico deve retornar uma String dizendo "Saldo insuficiente".

Ao executar o método depositar(), e a execução for com sucesso, deve retornar a mensagem "Depósito recebido com sucesso"

Ao executar o método login(), e a execução for com sucesso, deve retornar a mensagem "Usuário Autenticado". Caso falhe, deve retornar "Não foi possível autenticar o usuário"

Existe uma interface chamada Hardware que possui os métodos pegarNumeroDaContaCartao() para ler o número da conta do cartão para o login (retorna uma String com o número da conta), entregarDinheiro() que entrega o dinheiro no caso do saque (retorna void) e lerEnvelope() que recebe o envelope com dinheiro na operação de depósito (retorna void). Não tem nenhuma implementação disponível da interface Hardware e deve ser utilizado um Mock Object para ela durante os testes.

Todos os metodos da interface Hardware podem lançar uma exceção dizendo que houve uma falha de funcionamento do hardware.

Deve-se criar testes também para os casos de falha, principalmente na classe Hardware que pode falhar a qualquer momento devido a um mau funcionamento.

Lembre-se de usar o TDD e ir incrementando as funcionalidades aos poucos.

Você deve entregar o código final, incluindo os testes e os mock objects criados. Coloque todo código relativo a teste em uma pasta separada.



