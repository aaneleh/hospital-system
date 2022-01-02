# Sistema de Clinica Médica
![Badge jdk](https://img.shields.io/badge/jdk-16.0-orange)

## Indice
* [Características / Features](#características)
* [Demonstração / Demo](#demonstração)
    * [Login](#login)
    * [Home](#home)
    * [Registrar dados](#registrar-dados)
    * [Consultar dados](#consultar-dados)
* [Tecnologias / Tech](#tecnologias)
* [Como usar / How to use](#Como-usar)


## Características

- Registre-se e faça seu login
- Adicione outros usuários, médicos, marque consultas, etc, no banco de dados
- Visualize todos os registros e consultas disponíveis no banco de dados
- Edite e exclua dados


## Demonstração

### Login

![Tela a mensagem 'Bem-vindo', campos para email e senha, e botões para 'entrar' ou 'registrar-se'.](/demo/login.png)

### Home

![Tela a mensagem 'Bem-vindo' e botões para adicionar usuário, registrar paciente, registrar médicos, adicionar nova especialidade, nova clinica, marcar consulta, ver registro e ver consultas.](/demo/home.png)

### Registrar dados

![Tela a mensagem 'Marcar Consulta', campos para escrever o ID do médico, ID do paciente, data, descrição e status, e um botão para inserir.](/demo/registrar-dados.png)

### Consultar dados

![Tela a mensagem 'Todos os Registros Disponíveis', acima um botão para voltar e outro para reiniciar, abaixo tabelas de informações dos usuários, clinicas, especialidades, médicos e pacientes](/demo/consultar-dados.png)


## Tecnologias

- <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg"  width="25px" height="auto" />
- `JDK 16.0`
- `Apache Netbeans 12.5`
- `XAMPP 8.0`
- `MySQL Connector J 8.0`


## Como usar

1. Com o XAMPP, inicie o Modulo Apache e o MySQL
2. Entre no phpmyadmin e crie um banco de dados com o nome _**clinica**_
3. Clique em **importar** e selecione o arquivo `clinica.sql`
4. No Netbeans abra o projeto e o execute

Caso ocorra um erro SQL:

1. Clique com o botão direito no aplicação na lista de projetos e vá em bibliotecas
2. Adicione o Classpath para o **conector J** que deve estar na pasta do MySQL nos arquivos de programa, se não você precisará instalá-lo.
