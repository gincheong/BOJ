# Baekjoon Online Judge

백준 문제를 푸는 레포지토리입니다.

- `2309. 일곱 난쟁이` - [Java](./src/BOJ2309/Main.java)
- `2605. 줄 세우기` - [Java](./src/BOJ2605/Main.java)
- `2578. 빙고` - [Java](./src/BOJ2578/Main.java)
- `2563. 색종이` - [Java](./src/BOJ2563/Main.java)

## plop

Java 답안을 작성할 때 특히, `BufferedReader bReader ...` 와 같은 코드를 매번 반복해서 작성하는 것이 불편해서

js기반 Generator인 [plopjs](https://github.com/plopjs/plop)을 사용해 기본 파일을 생성하게 했습니다.

`npm install -g plop` 으로 plop을 설치하고, CLI를 통해서

`plop js`, `plop java` 를 입력하는 것으로 각각 **Node.js**, **Java** 에 맞는 기본 코드를 작성해줍니다.
