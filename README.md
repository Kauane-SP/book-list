📖 BookList | Diário Literário 

Visão Geral do Projeto

O BookList é uma aplicação mobile nativa para Android, desenvolvida em Kotlin e Jetpack Compose, que se propõe a ser o diário de bordo digital do leitor. O aplicativo oferece uma plataforma segura e intuitiva para que os usuários possam registrar, organizar e refletir sobre as obras literárias que consomem.

A aplicação se destaca por sua integração robusta com serviços de backend, utilizando o Firebase como principal fonte de dados (CRUD) e como solução completa de autenticação. Adicionalmente, o Google Books API é integrado para enriquecer a experiência do usuário, fornecendo inspirações de obras famosas.

🌟 Funcionalidades Principais

Autenticação (Firebase Authentication)

Experiência do usuário são garantidas através de um fluxo completo de autenticação:

Cadastro (Sign Up): Criação de novas contas com validação de dados.

Login (Sign In): Acesso seguro e persistente à plataforma.

Esqueci a Senha (Forgot Password): Mecanismo de recuperação de acesso via e-mail.

Gerenciamento de Resumos Literários (CRUD Firebase Firestore)

Esta é a funcionalidade central da aplicação, permitindo que o usuário gerencie seu conteúdo de leitura de forma completa:

Criar (Create): Adicionar um novo resumo literário, contendo:

* Título do Livro

* Nome do(a) Autor(a)

* Ano de Lançamento

* Resumo/Crítica Pessoal

* Nota de Avaliação (Score)

Ler (Read): Visualização de todos os resumos em formato de lista, com acesso aos detalhes.

Atualizar (Update/Edit): Modificação de qualquer campo de um resumo existente.

Deletar (Delete/Exclude): Remoção permanente de um resumo do seu diário.

Inspiração Literária (Google Books API)

Como um diferencial, o aplicativo oferece um módulo de inspiração:

Busca por Obras Famosas: Conexão com o Google Books API para retornar sugestões de obras populares, permitindo que o usuário se inspire para sua próxima leitura.

🏗️ Arquitetura do Projeto

O projeto adota uma arquitetura híbrida que mescla princípios de Clean Architecture com o padrão de design MVVM (Model-View-ViewModel).

Camada de Apresentação (Presentation Layer):

Views: Implementadas em Jetpack Compose para um Design System moderno e responsivo.

ViewModels: Gerenciam a lógica de visualização, formatam os dados e interagem com a Camada de Domínio, seguindo o padrão MVVM.

Data Sources:

Remote: Implementação para a comunicação com Firebase Firestore (resumos) e Google Books API (inspirações).

⚙️ Tecnologias e Ferramentas

* Kotlin

* Jetpack Compose

* MVVM

* Jetpack Navigation

* Firebase Auth / Firestore

* Koin

* Retrofit

* Coroutines

🚀 Configuração do Ambiente

Para rodar o projeto localmente, siga os passos abaixo:

Pré-requisitos

Android Studio (versão estável mais recente).

SDK do Android (Mínimo: 24, Recomendado: 34+).
