Oficina Aula 6
Nesta oficina, daremos continuidade ao que foi implementado na aula anterior, adicionando eventos aos botões criados na interface gráfica. Você deve utilizar o mesmo código da oficina anterior apenas para implementar eventos aos botões.

Etapa 1
Implementar a funcionalidade de adicionar um novo registro através do botão Salvar
Ao pressionar o botão Salvar, as informações deverão ser recebidas e carregadas na estrutura de dados que usamos anteriormente. Por exemplo, gravar um novo registro em um HashMap ou em um ArrayList etc. Após isso, mostrar uma tela informando que o registro foi inserido.
 
Etapa 2
Atualizar um registro já gravado
Para atualizar um registro, o usuário deverá preencher o campo de CPF ou RG e pressionar o botão Buscar (escolha o campo que você usou como chave na sua estrutura de dados). O sistema recuperará esse registro da estrutura de dados e preencherá os demais campos. O usuário atualizará os campos que achar necessário e pressionará o botão Salvar. Nesse momento, o sistema deve receber os dados da tela e deve guardar o registro. Se você usou um HashMap, ao guardar um registro nele, quando a chave usada já estiver sendo utilizada, o próprio HashMap já fará a substituição do registro anterior pelo novo, não mantendo dois registros com uma mesma chave. O sistema deverá mostrar uma mensagem indicando que o registro foi salvo (o procedimento de salvar pode ser o mesmo procedimento da Etapa 1).
Etapa 3
Remover um registro
Para remover um registro, o usuário deverá preencher o campo usado como chave (CPF ou RG, a depender de sua escolha de uso como chave na estrutura de dados) e pressionará o botão Remover. Caso haja um registro gravado com a chave passada, o sistema deverá mostrar uma tela que pede confirmação de exclusão, mostrando o nome do cliente. Caso não exista nenhum registro com a chave buscada, o sistema deve mostrar uma tela informando que não há nenhum cliente registrado com a chave (CPF ou RG). Dica: ao pressionar o botão Remover, o sistema deve fazer apenas uma busca nos registros. A remoção só será feita após a confirmação.