// BOJ7576: 토마토
const fs = require('fs')
const input = fs.readFileSync('src/BOJ7576/input.txt').toString().split('\n')
// const input = fs.readFileSync('./dev/stdin').toString().split('\n')

class Point {
  /**
   * @param {number} x
   * @param {number} y
   */
  constructor(x, y) {
    this.x = x
    this.y = y
  }
}

// 상자 크기
let C, R
// 토마토 상자 배열
const box = []
// 상하좌우를 탐색할 익은 토마토 리스트
let tomatoList = []
// 익지 않은 토마토 수
let rawTomatoCount = 0

// 상하좌우
const dxy = [
  new Point(-1, 0),
  new Point(1, 0),
  new Point(0, -1),
  new Point(0, 1),
]

const solution = () => {
  // Col, Row 입력받기
  ;[C, R] = input[0].split(' ').map((each) => parseInt(each))

  for (let i = 0; i < R; i++) {
    box.push(input[1 + i].split(' ').map((each) => parseInt(each)))
  }

  for (const i in box) {
    for (const j in box[0]) {
      if (box[i][j] == 1) {
        // 초기에 익은 상태의 토마토들 리스트에 추가
        tomatoList.push(new Point(i, j))
      } else if (box[i][j] == 0) {
        // 익지 않은 토마토 수 구하기
        rawTomatoCount++
      }
    }
  }

  const answer = BFS()

  console.log(answer)
}

const BFS = () => {
  // 익은 토마토 수
  let count = 0

  // 시간 경과
  let depth = -1
  while (tomatoList.length) {
    depth++

    const length = tomatoList.length

    for (let i = 0; i < length; i++) {
      // ! shift() 함수는 O(N)입니다.
      // const current = tomatoList.shift()

      const current = tomatoList[i]

      for (const each of dxy) {
        const nextRow = parseInt(current.x) + each.x
        const nextCol = parseInt(current.y) + each.y

        // 범위 내에 있고
        if (nextRow >= 0 && nextRow < R && nextCol >= 0 && nextCol < C) {
          // 익지 않은 토마토라면
          if (box[nextRow][nextCol] == 0) {
            box[nextRow][nextCol] = 1
            count++

            tomatoList.push(new Point(nextRow, nextCol))
          }
        }
      }
    }

    // 방문 마친 원소들 잘라내기
    tomatoList = tomatoList.slice(length)
  }

  if (count == rawTomatoCount) {
    return depth
  }

  return -1
}

solution()
