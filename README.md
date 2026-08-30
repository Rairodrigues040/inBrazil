# 🇧🇷 Rotas do Brasil (InBrazil)

Um aplicativo Android nativo desenvolvido para promover a exploração das regiões brasileiras, unindo **turismo, cultura e educação** em uma experiência interativa.

O **InBrazil** permite que o usuário explore as cinco regiões do Brasil, conheça informações sobre seus estados e teste seus conhecimentos por meio de um quiz interativo sobre geografia, capitais e cultura brasileira.

## 📱 Funcionalidades

### 🗺️ Navegação Regional

* Seleção entre as **5 regiões brasileiras**.
* Exploração dos **26 estados e do Distrito Federal**.
* Navegação organizada entre regiões, estados e informações detalhadas.

### 📍 Catálogo de Estados

* Listagem dos estados pertencentes à região selecionada.
* Interface visual e intuitiva para facilitar a exploração.

### 🌎 Detalhes dos Estados

* Informações sobre a **capital**.
* Curiosidades e aspectos **culturais**.
* Informações relacionadas ao **clima**.
* Consulta da **temperatura atual** por meio de API externa.

### 🧠 Quiz Interativo

* Perguntas sobre **geografia, capitais e conhecimentos gerais** do Brasil.
* Quatro alternativas por questão.
* Validação imediata da resposta selecionada.

### 📚 Feedback Educativo

* Indicação visual de respostas corretas e incorretas.
* Exibição de explicações para as respostas.
* Recurso desenvolvido para transformar o quiz em uma experiência de aprendizado.

### 🏆 Resultado

* Exibição da pontuação ao final do quiz.
* Quantidade de acertos e erros.
* Resumo do desempenho do usuário.

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia             | Utilização                                    |
| ---------------------- | --------------------------------------------- |
| **Kotlin**             | Linguagem principal do projeto                |
| **Jetpack Compose**    | Construção da interface de usuário            |
| **Navigation Compose** | Navegação entre as telas                      |
| **Room Database**      | Persistência e gerenciamento dos dados locais |
| **Retrofit**           | Comunicação com APIs externas                 |
| **GSON**               | Conversão e mapeamento dos dados JSON         |
| **Android SDK**        | Desenvolvimento da aplicação Android          |

---

## 🏗️ Arquitetura

O projeto utiliza uma estrutura organizada para separar as responsabilidades da aplicação, facilitando a manutenção e evolução do código.

Entre os principais componentes utilizados estão:

* **UI:** telas construídas com Jetpack Compose.
* **Navigation:** gerenciamento do fluxo de navegação utilizando Navigation Compose.
* **Database:** persistência dos dados utilizando Room.
* **API:** comunicação com serviços externos utilizando Retrofit.
* **Model:** representação dos dados utilizados pela aplicação.

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

## 🚀 Como rodar o projeto localmente

### Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

* **Android Studio**
* **JDK compatível com a versão do projeto**
* **Android SDK**
* Um dispositivo Android físico ou um **Android Emulator**

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

* Um dispositivo Android físico com **Depuração USB** habilitada; ou
* Um dispositivo virtual criado pelo **Android Studio (AVD)**.

### ▶️ 4. Execute o aplicativo

No Android Studio:

1. Selecione o dispositivo Android desejado.
2. Aguarde a sincronização do projeto.
3. Clique em **Run ▶**.
4. Aguarde a instalação e inicialização do aplicativo.

---

## 🌦️ API de clima

O aplicativo utiliza uma API externa para consultar informações meteorológicas e apresentar a temperatura atual do estado selecionado.

Para executar o projeto corretamente, verifique se as configurações necessárias da API estão presentes no projeto.

> **Importante:** não coloque chaves de API diretamente no código-fonte ou em um repositório público. Utilize variáveis de ambiente, `local.properties` ou outra forma segura de armazenamento.

---

## 📂 Estrutura do Projeto

Uma estrutura aproximada do projeto é:

```text
app/
└── src/
    └── main/
        └── java/
            └── com/
                └── rai/
                    └── inbrazil/
                        ├── data/
                        │   ├── database/
                        │   └── api/
                        │
                        ├── model/
                        │
                        ├── navigation/
                        │
                        └── ui/
                            ├── screens/
                            ├── components/
                            └── theme/
```

A estrutura pode variar de acordo com a organização atual do projeto.

---

## 🎯 Objetivo do Projeto

O **InBrazil** foi desenvolvido com o objetivo de utilizar a tecnologia como ferramenta de **educação e divulgação cultural**, proporcionando uma maneira simples e interativa de conhecer o Brasil.

Além da proposta educacional, o projeto também serve como aplicação prática de conceitos de desenvolvimento Android, como:

* Desenvolvimento com **Kotlin**;
* **Jetpack Compose**;
* Persistência de dados com **Room**;
* Consumo de APIs REST com **Retrofit**;
* Navegação entre telas;
* Gerenciamento de estado;
* Arquitetura e organização de projetos Android.

---

## 👨‍💻 Desenvolvedor

**Raí Rodrigues**

Projeto desenvolvido como parte da minha jornada de aprendizado e desenvolvimento em **Android/Kotlin**.
