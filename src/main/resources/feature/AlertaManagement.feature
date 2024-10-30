Feature: Gerenciamento de Alertas

  # Cenário 1: Caminho feliz para criação de alerta com dados válidos
  Scenario: Criar alerta com dados válidos
    Given que o usuário tem permissão para criar alertas
    When ele envia uma requisição POST para "/api/alertas" com dados válidos do alerta
    Then o sistema deve responder com status 201
    And o corpo da resposta deve conter os detalhes do alerta criado

  # Cenário 2: Caminho de erro para criação de alerta com dados inválidos
  Scenario: Falha ao criar alerta com dados inválidos
    Given que o usuário tenta criar um alerta com dados inválidos
    When ele envia uma requisição POST para "/api/alertas" com dados incompletos ou incorretos
    Then o sistema deve responder com status 400
    And o corpo da resposta deve conter uma mensagem de erro

  # Cenário 3: Caminho feliz para atualização de alerta existente com dados válidos
  Scenario: Atualizar alerta existente com dados válidos
    Given que existe um alerta cadastrado com ID 1
    When o usuário envia uma requisição PUT para "/api/alertas/1" com dados válidos do alerta
    Then o sistema deve responder com status 200
    And o corpo da resposta deve conter os detalhes atualizados do alerta

  # Cenário 4: Caminho de erro para atualização de alerta com ID inexistente
  Scenario: Falha ao atualizar alerta com ID inexistente
    Given que não existe alerta cadastrado com o ID fornecido
    When o usuário envia uma requisição PUT para "/api/alertas/{id_inexistente}"
    Then o sistema deve responder com status 404
    And o corpo da resposta deve conter uma mensagem de erro informando a inexistência do alerta

  # Cenário 5: Caminho feliz para exclusão de alerta existente
  Scenario: Excluir alerta existente
    Given que existe um alerta cadastrado com ID 1
    When o usuário envia uma requisição DELETE para "/api/alertas/1"
    Then o sistema deve responder com status 204
    And o alerta não deve mais existir no sistema
