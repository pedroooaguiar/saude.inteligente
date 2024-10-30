# "Saúde Inteligente" é uma aplicação desenvolvida em Java Spring com o objetivo de fornecer soluções para cidades inteligentes, incluindo funcionalidades para criação, atualização e exclusão de alertas. Este repositório contém o código-fonte, a configuração para CI/CD e os testes BDD escritos em Gherkin para garantir o correto funcionamento das APIs da aplicação.

# Pré-requisitos
Antes de iniciar, certifique-se de ter as seguintes ferramentas instaladas:
Java JDK 17
Maven
Docker e Docker Compose (para executar a aplicação em containers)
Git (para clonar o repositório e versionamento)

# Estrutura do Projeto
.github/workflows/ci-cd.yml: Configuração para o pipeline de CI/CD utilizando GitHub Actions.
docker-compose.yml: Arquivo Docker Compose para iniciar o ambiente de staging.
docker-compose.prod.yml: Arquivo Docker Compose para iniciar o ambiente de produção.
src/: Código fonte da aplicação e testes.
pom.xml: Arquivo de configuração do Maven com as dependências do projeto.
README.md: Documentação do projeto.

# Configuração do Projeto
Clonar o Repositório
Clone este repositório em sua máquina local e acesse o diretório do projeto:
git clone https://github.com/pedroooaguiar/saude.inteligente.git
cd saude.inteligente

# Instalar Dependências
Instale as dependências e compile o projeto com Maven:
mvn clean install

# Executando a Aplicação
Ambiente de Staging
Construir e Executar o Container: Para iniciar o ambiente de staging, use o comando abaixo:
docker-compose -f docker-compose.yml up --build
Acessar o Ambiente de Staging: Após o build, a aplicação estará disponível no endereço e porta configurados no docker-compose.yml.

# Ambiente de Produção
Criar uma Tag para a Versão: A criação de uma nova tag no Git acionará o pipeline de CI/CD para o ambiente de produção. Execute:
git tag v1.0.0  # Exemplo de tag
git push origin v1.0.0

Deploy no Ambiente de Produção: O pipeline de CI/CD construirá e implantará a aplicação no ambiente de produção. O arquivo docker-compose.prod.yml define as configurações para esse ambiente.

# Executando os Testes Automatizados
O projeto inclui testes BDD (Behavior-Driven Development) escritos em Gherkin e implementados com Cucumber, para garantir o comportamento correto da aplicação.

Configuração para Testes
Configurar o Ambiente de Teste: Certifique-se de que os serviços necessários estão configurados. A aplicação pode usar um banco de dados H2 para testes locais.

Executar os Testes com Maven:

Para rodar os testes automatizados e verificar o comportamento da aplicação, execute o comando:
mvn test

Este comando executará todos os testes, incluindo os testes de API para validação de status code e corpo de resposta.

# Executando Testes BDD com Cucumber
Os cenários de teste BDD estão descritos em src/test/resources/features/AlertaManagement.feature. Eles cobrem os principais fluxos de criação, atualização e exclusão de alertas. Para executar os testes BDD, basta executar:
mvn test -Dcucumber.options="src/test/resources/features/AlertaManagement.feature"


# Descrição dos Cenários de Teste BDD
Os cenários incluem fluxos positivos e de erro para as funcionalidades principais:

Cenário 1: Criar Alerta com Dados Válidos

Dado que o usuário tem permissão para criar alertas
Quando envia uma requisição POST para "/api/alertas" com dados válidos
Então o sistema responde com status 201 e o corpo contém os detalhes do alerta criado
Cenário 2: Falha ao Criar Alerta com Dados Inválidos

Dado que o usuário tenta criar um alerta com dados inválidos
Quando envia uma requisição POST para "/api/alertas" com dados incompletos ou incorretos
Então o sistema responde com status 400 e o corpo contém uma mensagem de erro
Cenário 3: Atualizar Alerta com Dados Válidos

Dado que existe um alerta cadastrado com ID 1
Quando o usuário envia uma requisição PUT para "/api/alertas/1" com dados válidos
Então o sistema responde com status 200 e o corpo contém os detalhes atualizados
Cenário 4: Falha ao Atualizar Alerta com ID Inexistente

Dado que não existe alerta cadastrado com o ID fornecido
Quando o usuário envia uma requisição PUT para "/api/alertas/{id_inexistente}"
Então o sistema responde com status 404 e o corpo contém uma mensagem de erro informando a inexistência do alerta
Cenário 5: Excluir Alerta Existente

Dado que existe um alerta cadastrado com ID 1
Quando o usuário envia uma requisição DELETE para "/api/alertas/1"
Então o sistema responde com status 204 e o alerta não deve mais existir no sistema

# Verificando Resultados dos Testes
Após a execução dos testes, os resultados serão armazenados no diretório target/cucumber em formato HTML. Acesse o relatório para ver o detalhamento de cada cenário.


# Pipeline CI/CD
O projeto possui um pipeline CI/CD configurado com GitHub Actions para automatizar a construção, teste e implantação da aplicação. O pipeline é acionado ao realizar push na branch principal (main) para o ambiente de staging ou ao criar uma tag para o ambiente de produção.

# Testando o Pipeline CI/CD
Executar CI/CD para Staging: Realize um commit e push para a branch main:
git add .
git commit -m "Commit de teste para staging"
git push origin main

# O GitHub Actions iniciará o pipeline e implantará a aplicação em staging.
Executar CI/CD para Produção: Crie uma tag e envie para o repositório:
git tag v1.0.1  # Ajuste a versão conforme necessário
git push origin v1.0.1



