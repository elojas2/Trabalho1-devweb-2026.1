# Trabalho1-devweb-2026.1

## Enunciado do Projeto: Construção de Sistema Web Seguro com Arquitetura MVC

Objetivo do Projeto Desenvolver um sistema Web completo e responsivo, aplicando os conceitos fundamentais de desenvolvimento Front-end e Back-end. O sistema deve ser projetado sob a arquitetura MVC (Model-View-Controller), garantindo a separação clara entre a lógica de negócios, o controle de requisições e a interface com o usuário. Além disso, o projeto focará em práticas reais de mercado, exigindo controle de versão, automação, persistência de dados em múltiplos níveis e suporte à segurança.

## Tecnologias Exigidas

Front-end: HTML5 (estruturação semântica), CSS3 (estilização e layout responsivo) e JavaScript (interatividade dinâmica e manipulação do DOM).
Back-end: Java com Servlets e JSP (JavaServer Pages).

Arquitetura e Padrões (Modelo MVC) O sistema deve implementar rigorosamente o padrão MVC:
Controller (Controlador): Implementado através de Servlets. O Servlet deve interceptar as requisições HTTP, processar os dados de entrada, interagir com o Model e utilizar o método RequestDispatcher.forward() para repassar a resposta à View correta.
Model (Modelo): Implementado através de JavaBeans e classes Java regulares. O Modelo deve encapsular a regra de negócios e o acesso ao armazenamento de dados.
View (Visão): Implementada através de páginas JSP. A View não deve conter lógicas complexas de programação, sendo responsável apenas por resgatar os atributos preparados pelo Controller e renderizar o HTML final para o usuário.

### Armazenamento de Dados

O sistema deve explorar e implementar diferentes níveis de armazenamento e persistência:
Banco de Dados Relacional: Utilizado para a persistência definitiva dos dados da aplicação. Recomenda-se a implementação de um Pool de Conexões (Connection Pool) para garantir a escalabilidade e o desempenho, evitando abrir uma nova conexão a cada requisição.
Sessões (Sessions): Utilizar a API HttpSession no Back-end para armazenar informações temporárias do usuário (ex: carrinho de compras, dados de perfil logado). Os dados da sessão devem persistir de forma segura na memória do servidor durante a navegação.
Cookies: Implementar o envio e leitura de Cookies para salvar preferências do cliente diretamente no browser, persistindo dados mesmo após o fechamento do navegador.Cache de Aplicação: Configurar corretamente os cabeçalhos HTTP (ex: Cache-Control, Expires) para otimizar o carregamento de arquivos estáticos no Front-end ou para evitar o cacheamento de páginas dinâmicas sensíveis.

### Segurança (Security Support) O sistema deve ser protegido em duas frentes

Front-end: Implementar validações de formulários com JavaScript para garantir a integridade inicial dos dados e prevenir injeções de código malicioso.
Back-end: Implementar um módulo de Autenticação e Autorização. Vocês podem utilizar Autenticação baseada em Formulários (Form-Based Authentication) ou Autenticação Básica HTTP (Basic Authentication). O sistema deve validar credenciais, associar o usuário a um perfil (Security Role) e proteger páginas JSP restritas. Servlets devem verificar se a sessão atual possui um usuário logado antes de conceder acesso aos métodos de negócio.

Controle de Versão (GitHub):O código-fonte deve ser obrigatoriamente hospedado no GitHub, utilizando boas práticas de versionamento (criação de branches, commits com sentido, Pull Requests e resolução de conflitos).

### Entregas e Avaliação

Repositório no GitHub atualizado, contendo o código-fonte, scripts de banco de dados e um arquivo README.md detalhando a arquitetura, como compilar e rodar o projeto.
Apresentação do sistema em funcionamento, onde será avaliada a separação correta das responsabilidades (MVC), a segurança aplicada e o uso efetivo das tecnologias solicitadas.
