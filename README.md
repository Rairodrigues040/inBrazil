# 🇧🇷 Rotas do Brasil (InBrazil)

Um aplicativo Android nativo desenvolvido para promover a exploração das regiões brasileiras, unindo **turismo, cultura e educação** em uma experiência interativa.

O **InBrazil** permite que o usuário explore as regiões brasileiras, conheça informações sobre seus estados e teste seus conhecimentos por meio de um quiz interativo sobre geografia, capitais e cultura brasileira.

> 🚧 **Status:** o projeto está em desenvolvimento. Atualmente, o fluxo funcional está disponível para a **Região Norte, especificamente para o estado do Acre**. Os demais estados e regiões ainda estão sendo desenvolvidos.

---

## 📱 Funcionalidades

### 🗺️ Navegação Regional

- Seleção entre as **5 regiões brasileiras**.
- Exploração dos estados de cada região.
- Navegação organizada entre regiões, estados e informações detalhadas.

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

---

## 🎥 Demonstração

Confira o funcionamento do aplicativo **InBrazil**:

[![Demonstração do InBrazil](https://img.youtube.com/vi/gpQn4GzBz6o/maxresdefault.jpg)](https://youtu.be/gpQn4GzBz6o)

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Utilização |
|---|---|
| **Kotlin** | Linguagem principal do projeto |
| **Jetpack Compose** | Construção da interface de usuário |
| **Navigation Compose** | Navegação entre as telas |
| **Room Database** | Persistência e gerenciamento dos dados locais |
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
- **API:** comunicação com serviços externos utilizando Retrofit.
- **Model:** representação dos dados utilizados pela aplicação.

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

Tela principal do aplicativo, onde o usuário pode escolher uma das regiões brasileiras.

### 🗺️ Estados

Lista dos estados pertencentes à região selecionada.

### 📍 Detalhes

Exibe informações sobre o estado, incluindo capital, aspectos culturais e temperatura atual.

### 🧠 Quiz

Perguntas interativas para testar os conhecimentos do usuário.

### 🏆 Resultado

Apresenta o desempenho final após a conclusão do quiz.

|                                                  Início                                                  |                                                  Estados                                                 |                                                 Detalhes                                                 |
| :------------------------------------------------------------------------------------------------------: | :------------------------------------------------------------------------------------------------------: | :------------------------------------------------------------------------------------------------------: |
| <img src="https://github.com/user-attachments/assets/66c9be76-eb07-47d5-9223-967496920dd5" width="200"/> | <img src="https://github.com/user-attachments/assets/6ab86046-f8a8-4e71-858d-f4ba208e8664" width="200"/> | <img src="https://github.com/user-attachments/assets/70e76ec7-b517-4c4f-86ca-33faad20fc33" width="200"/> |

|                                                   Quiz                                                   |                                                 Resposta                                                 |                                                 Resultado                                                |
| :------------------------------------------------------------------------------------------------------: | :------------------------------------------------------------------------------------------------------: | :------------------------------------------------------------------------------------------------------: |
| <img src="https://github.com/user-attachments/assets/f50c40b4-3f1e-43d0-a3cf-cba084f121e2" width="200"/> | <img src="https://github.com/user-attachments/assets/10a118ad-bc5e-499a-903f-89703ba5f3af" width="200"/> | <img src="https://github.com/user-attachments/assets/f2b7531c-8de3-4ba9-8e41-e72cb9d464a9" width="200"/> |

---

## 🚧 Status do Projeto

O **InBrazil** está em desenvolvimento.

Atualmente, o fluxo funcional disponível é:

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

Os demais estados e regiões ainda estão sendo desenvolvidos e serão adicionados progressivamente ao projeto.

### 🔜 Próximos passos

- [ ] Implementar os demais estados da Região Norte.
- [ ] Implementar as demais regiões brasileiras.
- [ ] Adicionar informações detalhadas para todos os estados.
- [ ] Expandir a integração com a API de clima.
- [ ] Ampliar o banco de perguntas do quiz.
- [ ] Melhorar a experiência de navegação e interação.
- [ ] Adicionar novos conteúdos culturais e turísticos.

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

Como o projeto ainda está em desenvolvimento, utilize o seguinte caminho para testar as funcionalidades disponíveis:

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
- **Jetpack Compose**;
- Persistência de dados com **Room**;
- Consumo de APIs REST com **Retrofit**;
- Navegação entre telas;
- Gerenciamento de estado;
- Organização e arquitetura de projetos Android.

---

## 👨‍💻 Desenvolvedor

**Raí Rodrigues**

Projeto desenvolvido como parte da minha jornada de aprendizado e desenvolvimento em **Android/Kotlin**.

---
