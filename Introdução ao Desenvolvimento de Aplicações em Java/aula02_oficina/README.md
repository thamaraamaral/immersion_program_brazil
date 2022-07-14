Oficina Aula 2
Com esta atividade daremos continuidade ao código da oficina anterior. Após a codificação no sistema do cadastro de hóspedes de um hotel, deparamo-nos com algumas situações que podem gerar fluxos alternativos com os quais o software deve lidar. Em outras palavras, o sistema deve ser capaz de lidar com erros acidentais, ou propositais, por parte do usuário, pois são situações típicas da interação humano-computador.

A seguir, em cada etapa, serão listados alguns cenários nos quais você deve usar os blocos try-catch para tratar o tipo específico da exceção. Em cada caso, mostre uma mensagem informando que determinada entrada não é permitida. Dica: para exibir as mensagens de erro, ao invés de usar o método System.out.println(), use o método System.err.println().

Etapa 1
Suponha que a atendente do hotel, acidentalmente, digitou um valor textual no campo “idade”. Para esse cenário, será lançada uma exceção do tipo InputMismatchException.
Na classe Principal, circunde o trecho de código que captura a entrada e exiba uma mensagem de erro ao usuário.
 
Etapa 2
Suponha ainda que, no momento em que o sistema requisitou o CPF do hóspede (tipo long), acidentalmente, a atendente inseriu uma vírgula na caixa de entrada e, por causa disso, uma exceção foi lançada.
Identifique qual tipo de exceção foi lançado, simulando o caso.
Crie uma forma para que essa exceção seja capturada e uma mensagem de erro seja exibida ao usuário.
 
Etapa 3
Apesar de o tipo String aceitar quaisquer caracteres, sejam textuais, especiais, ou numéricos, não é interessante que haja o ingresso de valores numéricos, vírgulas, barras ou pontos no campo nome.
Neste caso, iremos evitar o lançamento de uma exceção. Faremos apenas uma validação. Declare um método que receba como parâmetro o objeto String nome e valide essa informação. O método deverá retornar um valor booleano. Ele retornará true, em caso de o valor passado for válido (não contiver caracteres numéricos, vírgulas, barras ou pontos) ou false, caso contrário.