# 🇧🇷 Rotas do Brasil (InBrazil)

Um aplicativo Android nativo desenvolvido para promover a exploração das regiões brasileiras, unindo **turismo, cultura e educação** em uma experiência interativa.

O **InBrazil** permite que o usuário explore as regiões brasileiras, conheça informações sobre seus estados, teste seus conhecimentos por meio de um quiz interativo e compartilhe suas experiências de viagem através de comentários.

> 🚧 **Status:** o projeto está em desenvolvimento. Atualmente, o fluxo de exploração regional está disponível principalmente para a **Região Norte, especificamente para o estado do Acre**. Outras regiões e estados estão sendo desenvolvidos progressivamente.

---

## 📱 Funcionalidades

### 🗺️ Navegação Regional

- Seleção entre as **5 regiões brasileiras**.
- Exploração dos estados de cada região.
- Navegação organizada entre regiões, estados e informações detalhadas.
- Barra de navegação inferior para facilitar o acesso às principais funcionalidades.

### 📍 Catálogo de Estados

- Listagem dos estados pertencentes à região selecionada.
- Interface visual e intuitiva para facilitar a exploração.
- Organização dos estados de acordo com suas respectivas regiões.

### 🌎 Detalhes dos Estados

- Informações sobre a **capital**.
- Curiosidades e aspectos **culturais**.
- Informações relacionadas ao **clima**.
- Consulta da **temperatura atual** por meio de uma API externa.

### 🧠 Quiz Interativo

- Perguntas sobre **geografia, capitais e conhecimentos gerais** do Brasil.
- Quatro alternativas por questão.
- Validação imediata da resposta selecionada.

### 📚 Feedback Educativo

- Indicação visual de respostas corretas e incorretas.
- Exibição de explicações para as respostas.
- Recurso desenvolvido para transformar o quiz em uma experiência de aprendizado.

### 🏆 Resultado

- Exibição da pontuação ao final do quiz.
- Quantidade de acertos e erros.
- Resumo do desempenho do usuário.

### 💬 Sistema de Comentários

Funcionalidade desenvolvida para permitir que os usuários compartilhem suas experiências e opiniões sobre os locais explorados no aplicativo.

Principais recursos:

- Cadastro de comentários com nome do usuário.
- Adição de fotografias aos comentários.
- Campo de texto com limite de 200 caracteres.
- Identificação do estado relacionado ao comentário.
- Listagem dos comentários cadastrados.
- Edição de comentários existentes.
- Exclusão de comentários com confirmação.
- Armazenamento local dos dados utilizando Room Database.

---

## 🎥 Demonstração

Confira o funcionamento do aplicativo **InBrazil**:

[![Demonstração do InBrazil](https://img.youtube.com/vi/gpQn4GzBz6o/maxresdefault.jpg)](https://youtu.be/gpQn4GzBz6o)

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Utilização |
|---|---|
| **Kotlin** | Linguagem principal do projeto |
| **Jetpack Compose** | Construção das interfaces de usuário |
| **Material 3** | Componentes e elementos visuais |
| **Navigation Compose** | Navegação entre as telas |
| **Room Database** | Persistência e gerenciamento dos dados locais |
| **Kotlin Coroutines** | Execução de operações assíncronas |
| **Flow** | Observação e atualização dos dados em tempo real na interface |
| **ViewModel** | Gerenciamento dos estados e da lógica das telas |
| **Repository Pattern** | Organização do acesso aos dados |
| **Retrofit** | Comunicação com APIs externas |
| **GSON** | Conversão e mapeamento dos dados JSON |
| **Android SDK** | Desenvolvimento da aplicação Android |

---

## 🏗️ Arquitetura

O projeto utiliza uma estrutura organizada para separar as responsabilidades da aplicação, facilitando a manutenção e evolução do código.

Entre os principais componentes utilizados estão:

- **UI:** telas construídas com Jetpack Compose.
- **Navigation:** gerenciamento do fluxo de navegação utilizando Navigation Compose.
- **Database:** persistência dos dados utilizando Room.
- **DAO:** definição das operações de acesso ao banco de dados.
- **Repository:** camada responsável por intermediar o acesso aos dados.
- **ViewModel:** gerenciamento dos estados e das operações relacionadas às funcionalidades.
- **API:** comunicação com serviços externos utilizando Retrofit.
- **Entity:** representação das entidades armazenadas no banco de dados.

### 💾 Persistência de dados com Room

O aplicativo utiliza o Room Database para armazenar informações localmente.

Atualmente, o banco de dados contempla entidades relacionadas a:

- **Perguntas:** armazenamento das questões utilizadas no quiz.
- **Comentários:** armazenamento das experiências compartilhadas pelos usuários.

O sistema de comentários utiliza uma estrutura organizada em:

```text
data/
├── dao/
│   ├── PerguntaDao.kt
│   └── ComentarioDao.kt
│
├── database/
│   └── QuizDatabase.kt
│
├── entity/
│   ├── PerguntaEntity.kt
│   └── ComentarioEntity.kt
│
├── repository/
│   └── ComentarioRepository.kt
│
└── presentation/
    ├── QuizViewModel.kt
    ├── ComentarioViewModel.kt
    └── ComentarioViewModelFactory.kt
```

A comunicação entre o banco de dados e a interface é realizada por meio de DAO, Repository e ViewModel, utilizando Coroutines e Flow para operações assíncronas e observação dos dados.

---

## 🌦️ API de Clima

O aplicativo utiliza uma **API de clima** para consultar e exibir informações meteorológicas, como a **temperatura atual** do estado selecionado.

A integração com a API é realizada utilizando:

- **Retrofit** para realizar as requisições HTTP.
- **GSON** para converter os dados retornados pela API em objetos Kotlin.

### 📌 Fluxo atualmente disponível

No momento, a integração e o fluxo funcional estão disponíveis para:

**Região Norte → Acre → Informações do estado → Clima**

Os demais estados e regiões ainda estão sendo desenvolvidos.

> ⚠️ **Importante:** ao executar o projeto atualmente, recomenda-se utilizar o fluxo da **Região Norte → Acre**, pois os demais caminhos ainda estão em desenvolvimento.

---

## 📸 Telas do Aplicativo

### 🏠 Início

Tela principal do aplicativo, onde o usuário pode acessar as regiões brasileiras.

### 🗺️ Estados

Lista dos estados pertencentes à região selecionada.

### 📍 Detalhes

Exibe informações sobre o estado, incluindo capital, aspectos culturais e temperatura atual.

### 🧠 Quiz

Perguntas interativas para testar os conhecimentos do usuário.

### 🏆 Resultado

Apresenta o desempenho final após a conclusão do quiz.

### 💬 Comentários

Área destinada ao compartilhamento de experiências, permitindo cadastrar, visualizar, editar e excluir comentários, além de adicionar fotografias.

### 📷 Capturas de tela

| Início | Estados | Detalhes |
|:---:|:---:|:---:|
| <img src="https://github.com/user-attachments/assets/66c9be76-eb07-47d5-9223-967496920dd5" width="200"/> | <img src="https://github.com/user-attachments/assets/6ab86046-f8a8-4e71-858d-f4ba208e8664" width="200"/> | <img src="https://github.com/user-attachments/assets/70e76ec7-b517-4c4f-86ca-33faad20fc33" width="200"/> |

| Quiz | Resposta | Resultado |
|:---:|:---:|:---:|
| <img src="https://github.com/user-attachments/assets/f50c40b4-3f1e-43d0-a3cf-cba084f121e2" width="200"/> | <img src="https://github.com/user-attachments/assets/10a118ad-bc5e-499a-903f-89703ba5f3af" width="200"/> | <img src="https://github.com/user-attachments/assets/f2b7531c-8de3-4ba9-8e41-e72cb9d464a9" width="200"/> |

> As capturas de tela da funcionalidade de comentários serão adicionadas posteriormente.

---

## 🚧 Status do Projeto

O **InBrazil** está em desenvolvimento.

Atualmente, o projeto contempla os seguintes fluxos:

### Exploração regional

```text
🇧🇷 Início
   ↓
🌎 Região Norte
   ↓
📍 Acre
   ↓
🌡️ Informações do estado
   ↓
🌦️ Temperatura atual
```

### Quiz

```text
🧠 Quiz
   ↓
❓ Perguntas
   ↓
✅ Validação das respostas
   ↓
📚 Explicações
   ↓
🏆 Resultado
```

### Comentários

```text
💬 Comentários
   ↓
➕ Adicionar comentário
   ↓
📝 Preencher informações
   ↓
📷 Selecionar fotografia
   ↓
💾 Salvar no Room
   ↓
📋 Listar comentários
   ↓
✏️ Editar ou excluir
```

### 🔜 Próximos passos

- [ ] Implementar os demais estados da Região Norte.
- [ ] Implementar as demais regiões brasileiras.
- [ ] Adicionar informações detalhadas para todos os estados.
- [ ] Expandir a integração com a API de clima.
- [ ] Ampliar o banco de perguntas do quiz.
- [ ] Melhorar a experiência de navegação e interação.
- [ ] Expandir o sistema de comentários para relacioná-los aos respectivos locais visitados.
- [ ] Adicionar novos conteúdos culturais e turísticos.
- [ ] Aprimorar a interface e a identidade visual do aplicativo.

---

## 🚀 Como Rodar o Projeto Localmente

### Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- **Android Studio**
- **JDK compatível com a versão do projeto**
- **Android SDK**
- Um dispositivo Android físico ou um **Android Emulator**

### 📥 1. Clone o repositório

```bash
git clone https://github.com/SEU-USUARIO/SEU-REPOSITORIO.git
```

Entre na pasta do projeto:

```bash
cd SEU-REPOSITORIO
```

### 🔧 2. Abra o projeto

Abra a pasta do projeto no **Android Studio**.

Aguarde o Android Studio concluir a sincronização do **Gradle** e o download das dependências necessárias.

### 📱 3. Configure um dispositivo

Você pode executar o aplicativo utilizando:

- Um dispositivo Android físico com **Depuração USB** habilitada; ou
- Um dispositivo virtual criado pelo **Android Studio (AVD)**.

### ▶️ 4. Execute o aplicativo

No Android Studio:

1. Selecione o dispositivo Android desejado.
2. Aguarde a sincronização do projeto.
3. Clique em **Run ▶**.
4. Aguarde a instalação e inicialização do aplicativo.

### ⚠️ Fluxo recomendado

Como o projeto ainda está em desenvolvimento, utilize o seguinte caminho para testar as funcionalidades de exploração regional:

```text
Início
  ↓
Região Norte
  ↓
Acre
```

---

## 🎯 Objetivo do Projeto

O **InBrazil** foi desenvolvido com o objetivo de utilizar a tecnologia como ferramenta de **educação e divulgação cultural**, proporcionando uma maneira simples e interativa de conhecer o Brasil.

Além da proposta educacional, o projeto também serve como aplicação prática de conceitos de desenvolvimento Android, como:

- Desenvolvimento com **Kotlin**;
- Construção de interfaces com **Jetpack Compose**;
- Persistência de dados com **Room**;
- Consumo de APIs REST com **Retrofit**;
- Navegação entre telas;
- Gerenciamento de estado;
- Arquitetura baseada em ViewModel e Repository;
- Programação assíncrona com Coroutines e Flow.

---

## 👨‍💻 Desenvolvedor

**Raí Rodrigues**

Projeto desenvolvido como parte da minha jornada de aprendizado e desenvolvimento em **Android/Kotlin**.
