<h1 align="center">Time Melhor Rota</h1>

<div align="center">
<img src="https://github.com/NExT-2023-1/t01-melhor-rota/assets/108696459/9d7ce0d2-d934-4170-bedd-f1f86a61eace" width="400px"> 
</div>





## 🚚 ROUTE WISE - API

RouteWise é uma API desenvolvida para otimizar o transporte de carga em ambientes de minas:

- A API oferece rota com base na eficiência e na economicidade, de acordo com o status dos caminhões, proporcionando economia de tempo e recursos.

- Os usuários podem cadastrar, buscar, atualizar e excluir informações dos caminhões, incluindo sua localização e status (cheio ou vazio).

- De acordo com as rotas pré-definidas, conforme a necessidade do cliente, facilitando a busca e o registro de rotas específicas para suas operações logísticas.

- A API é facilmente testada e utilizada com uma ferramenta de gerenciamento de APIs, como por exemplo a API Insomnia.

## 🙋‍♂️ Criado por:
- [Igor Menezes](http://github.com/igorcdemenezes)
- [Maria Eduarda Vasconcelos](https://github.com/eduardavasc)
- [Matheus Lustosa](https://github.com/MatheusLustosa)
- [Mozana Montenegro](https://github.com/MozanaMMMB)
- [Natani Monte](https://github.com/Natani-monte)

Mentoria:
- [Danilo Alfredo](https://github.com/daniloalfredo)

  
Trabalho de conclusão do curso NExT - Nova Experiência de Trabalho.
## 📝 UML
<div align="center">
<img src="https://github.com/NExT-2023-1/t01-melhor-rota/assets/108696459/042db0fb-9587-4b7d-b4c0-545384d8e540" width="1000px"> 
</div>


## ⚙️ Como rodar na sua máquina?
- OpenJDK 17.0.2+;
- Maven 4.0+;
- IDE de sua preferência;
- API Client de sua preferência;
- Spring Boot 3.1.3; 
- MySQL;
  
<strong>OBS:</strong> Para rodar a aplicação, será necessário ir em Aplication Properties e atualizar os dados de username e senha, considerando seu banco de dados local.
## 💻Tecnologias Utilizadas

![image](https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=slack&logoColor=white)
![image](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)
![image](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![image](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Insomnia](https://img.shields.io/badge/Insomnia-black?style=for-the-badge&logo=insomnia&logoColor=5849BE)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![image](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)
![image](https://img.shields.io/badge/Git-E34F26?style=for-the-badge&logo=git&logoColor=white)
![image](https://img.shields.io/badge/Windows-017AD7?style=for-the-badge&logo=windows&logoColor=white)
![Trello](https://img.shields.io/badge/Trello-%23026AA7.svg?style=for-the-badge&logo=Trello&logoColor=white)

## 🌐 ENDPOINTS

Após rodar a aplicação e com o banco de dados sincronizado na sua máquina, você precisará de uma ferramenta para fazer REST Requests. Todos os testes de funcionalidade do CRUD e do retorno da melhor rota foram feitos usando o Insomnia.

O banco de dados recebe informações sobre os caminhões, com os parâmetros "status" e "location".

<strong>OBS:</strong> O ID do caminhão é gerado automaticamente.

Utilize o seguinte formato:

{

"status": "true",

"location": "Int3"

}

CAMINHO:
http://localhost:8080/truck 

COMANDOS:

- GET - Retornar a lista de caminhões cadastrados no banco de dados;
- POST - Adicionar um novo caminhão no banco;
- PUT - Editar caminhão existente no banco de dados;
- DELETE - Excluir caminhão existente no banco de dados;
- GET BY ID - Retorna a melhor rota pelo ID do caminhão já cadastrado;


