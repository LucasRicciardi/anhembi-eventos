# Aplicação de Gerenciamento de Eventos

Esta aplicação permite gerenciar usuários, eventos e inscrições em eventos.

## Como Executar

1. Certifique-se de ter o Java JDK instalado em sua máquina.
2. Baixe o código-fonte da aplicação.
3. Abra o terminal e navegue até o diretório onde o código-fonte foi baixado.
4. Compile o código-fonte executando o seguinte comando:
    ```bash
    javac -d dist src/*.java src/**/*.java
    ```
5. Após compilar com sucesso, execute o aplicativo com o seguinte comando:
    ```bash
    java -cp dist Main
    ```
6. Siga as instruções apresentadas no terminal para interagir com o aplicativo.

## Comandos Disponíveis

- `createUser`: Cria um novo usuário.
- `listUsers`: Lista todos os usuários cadastrados.
- `createEvent`: Cria um novo evento.
- `listEvents`: Lista todos os eventos cadastrados.
- `listPastEvents`: Lista os eventos que já ocorreram.
- `addUserToEvent`: Inscreve um usuário em um evento.
- `removeUserFromEvent`: Cancela a inscrição de um usuário em um evento.
- `listUserEvents`: Lista os eventos em que um usuário está inscrito.

## Contribuindo

- Se você encontrar problemas ou bugs, sinta-se à vontade para abrir uma issue neste repositório.
- Se desejar contribuir com código, faça um fork deste repositório, faça suas alterações e envie uma solicitação de pull.

Aproveite a aplicação!

