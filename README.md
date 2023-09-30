# StockEgine
Projeto de Armazenamento de Motores de Carros
Este é um projeto de exemplo que demonstra como criar um aplicativo Java com interface gráfica (GUI) usando a biblioteca Swing para armazenar informações sobre motores de carros em um banco de dados MySQL usando JDBC. O aplicativo permite a adição, remoção e atualização de informações sobre motores e exibe esses dados em uma tabela dentro do programa.

Pré-requisitos
Antes de começar a usar o aplicativo, certifique-se de que você tenha o seguinte instalado em seu sistema:

Java Development Kit (JDK) - Versão 8 ou superior
MySQL - Um servidor MySQL configurado e em execução
Biblioteca JDBC para MySQL
Ambiente de desenvolvimento Java (por exemplo, Eclipse, IntelliJ IDEA, NetBeans)
Configuração do Banco de Dados
Crie um banco de dados MySQL chamado motores.
Execute o script SQL fornecido no arquivo create_table.sql para criar a tabela engines no banco de dados. Esse script também inclui alguns dados de exemplo.
Compilando e Executando o Aplicativo
Clone este repositório para o seu sistema local.
Abra o projeto em seu ambiente de desenvolvimento Java.
Certifique-se de configurar o driver JDBC para MySQL em seu ambiente.
Compile e execute o aplicativo a partir da classe Main.java.
Uso do Aplicativo
Após executar o aplicativo, você verá uma janela com uma interface simples que permite realizar as seguintes operações:

Adicionar Motor: Preencha os campos de Marca, Modelo, Motor e Potência e clique em "Adicionar" para inserir um novo motor no banco de dados.
Remover Motor: Selecione um motor na tabela e clique em "Remover" para excluí-lo do banco de dados.
Atualizar Motor: Selecione um motor na tabela, faça as alterações necessárias nos campos e clique em "Atualizar" para salvar as alterações no banco de dados.
As informações sobre os motores serão exibidas na tabela abaixo das opções.

Contribuições
Contribuições são bem-vindas! Se você deseja contribuir para este projeto, siga estas etapas:

Faça um fork deste repositório.
Crie uma nova branch com sua funcionalidade: git checkout -b minha-nova-funcionalidade.
Faça suas alterações e faça commit delas: git commit -m 'Adicionei uma nova funcionalidade'.
Envie suas alterações para o seu fork: git push origin minha-nova-funcionalidade.
Crie um pull request para este repositório.
Licença
Este projeto está licenciado sob a Licença MIT.
