# GameNest

GameNest é uma plataforma de comércio de jogos, onde usuários podem compartilhar suas avaliações de jogos com a comunidade.

# Equipe

Jean Guichard²
Matheus Augusto Daminelli
Lucas Da Rosa

## Casos de Uso

- Criar e alterar jogos
- Manipular avaliações de jogos

# Recursos

### - `Jogo`
```json
{
  "nome": "Celeste",
  "descricao": "A escalada de uma montanha",
  "preco": 29.99,
  "genero": "Plataforma",
  "desenvolvedor": "Maddy Makes Games",
  "dataLancamento": "2018-01-24"
}
```

### - `Avaliação`
```json
{
  "titulo": "Perfeito",
  "nota": 9.5,
  "comentario": "Jogo fascinante!"
}
```

# Endpoints

| Descrição                             | URI                                                 | Método HTTP | Corpo                                                                          | Resposta Esperada                               | Erros Esperados                      |
|---------------------------------------|-----------------------------------------------------|-------------|--------------------------------------------------------------------------------|-------------------------------------------------|--------------------------------------|
| Retornar um jogo                      | `GET /jogos/{jogo-id}`                              | GET         | Vazio                                                                          | `200 OK` com detalhes do jogo                   | `404 Not Found` - jogo não foi encontrado. |
| Retornar avaliações do jogo           | `GET /jogos/{jogo-id}/avaliacoes`                   | GET         | Vazio                                                                          | `200 OK` com lista de avaliações                | `404 Not Found` - jogo não foi encontrado. |
| Retornar uma avaliação do jogo        | `GET /jogos/{jogo-id}/avaliacoes/{avaliacao-id}`    | GET         | Vazio                                                                          | `200 OK` com detalhes da avaliação              | `404 Not Found` - jogo ou avaliação não foi encontrado. |
| Inserir novo jogo                     | `POST /jogos`                                       | POST        | `{ "nome": "Novo Jogo", "descricao": "Descrição do jogo", "preco": 29.99 }`    | `201 Created` com detalhes do novo jogo         | `400 Bad Request` - dados inválidos. |
| Atualizar jogo                        | `PUT /jogos/{jogo-id}`                              | PUT         | `{ "nome": "Jogo Atualizado", "descricao": "Nova descrição", "preco": 24.99 }` | `200 OK` com detalhes do jogo atualizado        | `404 Not Found` - jogo não foi encontrado. |
| Inserir nova avaliação                | `POST /jogos/{jogo-id}/avaliacoes`                  | POST        | `{ "titulo": "Ótimo jogo!", "nota": 9.5 }`                                     | `201 Created` com detalhes da nova avaliação    | `404 Not Found` - jogo não foi encontrado. |
| Atualizar avaliação                   | `PUT /jogos/{jogo-id}/avaliacoes/{avaliacao-id}`    | PUT         | `{ "nota": 8.0 }`                                                              | `200 OK` com detalhes da avaliação atualizada   | `404 Not Found` - jogo ou avaliação não foi encontrado. |
| Deletar uma avaliação                 | `DELETE /jogos/{jogo-id}/avaliacoes/{avaliacao-id}` | DELETE      | Vazio                                                                          | `200 OK` indicando que a avaliação foi deletada | `404 Not Found` - jogo ou avaliação não foi encontrado. |
----------