# kotlin-minesweeper

## 지뢰 찾기(그리기)
```
지뢰 찾기를 변형한 프로그램을 구현한다.

높이와 너비, 지뢰 개수를 입력받을 수 있다.
지뢰는 눈에 잘 띄는 것으로 표기한다.
지뢰는 가급적 랜덤에 가깝게 배치한다.
```
### row
- [x] row는 0미만이 될 경우 예외가 발생한다.

### column
- [x] column는 0미만이 될 경우 예외가 발생한다.

### field type
- mine
- none

### cell
- [x] cell은 cell type을 가진다.
- [x] cell은 row와 column을 가진다.
- [x] 지뢰로 변경할 때 이미 지뢰라면 예외가 발생한다.
- [x] 동일한 위치의 cell은 같은 cell이다.

### mine board
- [x] 지뢰 찾기 맵은 cell들로 구성된다.
- [x] 지뢰 숫자를 받아 랜덤한 위치에 지뢰를 배치한다.
- [x] 이미 지뢰가 배치되어있는데 지뢰를 배치하려하면 예외가 발생한다.
- [x] 요청된 지뢰 갯수가 0개인 경우 예외가 발생한다.
- [x] 요청된 지뢰 갯수가 현재 cell크기보다 큰 경우 예외가 발생한다.

### input view
```
높이를 입력하세요.
10

너비를 입력하세요.
10

지뢰는 몇 개인가요?
10
```
- [x] 높이를 입력받는다.
  - 높이는 숫자여야 한다.
- [x] 너비를 입력받는다.
  - 너비는 숫자여야 한다.
- [x] 지뢰를 입력받는다.
  - 지뢰는 숫자여야 한다.

### output view
```
지뢰찾기 게임 시작
C C C * C C C * C C
C C * C * C C C C C
C C C C C C C C C C
C C C C C C C C C C
* C C C C C C C C C
C C C C C C * C C C
C C * C C C * C C C
C C C C C C * C C *
C C C C C C C C C C
C C C C C C C C C C
```

## 지뢰 찾기(지뢰 개수)
```
지뢰 찾기를 변형한 프로그램을 구현한다.

높이와 너비, 지뢰 개수를 입력받을 수 있다.
지뢰는 눈에 잘 띄는 것으로 표기한다.
지뢰는 가급적 랜덤에 가깝게 배치한다.
각 사각형에 표시될 숫자는 자신을 제외한 주변 8개 사각형에 포함된 지뢰의 개수다.
```

### coordinate
- row와 column을 가진다.
- [x] 상하좌우로 이동할 수 있다.

### finder
- [x] 본인의 대각선 방향 모두를 검색할 수 있다.
- [x] 모든 방향에 있는 좌표를 반환할 수 있다.

### cell type
- [x] 0~8은 적정 cell type을 반환한다.
- [x] 조건에 없는 경우 예외가 발생한다.

### cell
- 현재는 모든 display가 open되어있다.
- [x] display가 가능할 때 실제 cell type을 반환한다.
- [x] display가 불가능일 때 UNKNOWN을 반환한다.

### mine board
- [x] 지뢰를 둘 때 자리에 주변 지뢰 갯수를 계산해 type을 지정해두어야 한다.
- [x] 본인의 사각형 범위에 존재하는 지뢰의 수가 본인의 숫자다.
  - index 범위를 벗어난 값은 제외한다.

### 

### output view
```
지뢰찾기 게임 시작
0 1 2 * 2 1 1 * 1 0
0 1 * 3 * 1 1 1 1 0
0 1 1 2 1 1 0 0 0 0
1 1 0 0 0 0 0 0 0 0
* 1 0 0 0 1 1 1 0 0
1 2 1 1 0 2 * 2 0 0
0 1 * 1 0 3 * 3 1 1
0 1 1 1 0 2 * 2 1 *
0 0 0 0 0 1 1 1 1 1
0 0 0 0 0 0 0 0 0 0
```

### 지뢰 찾기(게임 실행)
```
높이와 너비, 지뢰 개수를 입력받을 수 있다.
지뢰는 눈에 잘 띄는 것으로 표기한다.
지뢰는 가급적 랜덤에 가깝게 배치한다.
각 사각형에 표시될 숫자는 자신을 제외한 주변 8개 사각형에 포함된 지뢰의 개수다.
지뢰가 없는 인접한 칸이 모두 열리게 된다.
```

### cell
- [x] 초기 생성 시 isDisplay는 false다.
- [x] 이미 열린 좌표를 변경하려하면 예외가 발생한다.

### cells
- [x] 존재하지 않는 좌표가 입력되는 경우 예외가 발생한다.
- [x] cell이 0이 아니라면 해당 좌표만 열린다.
- [x] cell이 0이라면 주변 좌표가 모두 열리고, 0인 좌표에 전파된다.
- [x] 오픈된 cell 갯수만큼 반환한다.

### mine board
- open
  - [x] 좌표가 지뢰라면 게임이 종료된다.
  - [x] 종료된 게임에서 open요청을 할 경우 예외가 발생한다.
- [x] 종료된 게임인지 확인할 수 있다.
- [x] 게임 결과가 승리인지 패배인지 확인 시 아직 진행중이면 예외가 발생한다.

### input view
```
지뢰찾기 게임 시작
open: 1, 1
```
- [x] 좌표를 입력할 수 있다.
  - [x] 좌표는 숫자만 입력가능하여야하며, 2개의 숫자만 입력하지 않는 경우 예외가 발생한다.

### output view
```
Lose Game.
```
- [x] 지뢰를 누르면 종료 문구가 출력된다.


## 지뢰찾기(리팩터링)

### cell
- [x] cell type과 현재 오픈가능한지 여부를 가지고 있다.
- [ ] 오픈되지 않은 상태라면 unknown을, 오픈된 상태라면 현재 cell type을 반환한다.
- [x] 이미 오픈된 좌표를 오픈하려하면 예외가 발생한다.

### cell type
- [x] 0~8, 지뢰, unknown 타입을 가지고 있다.

### coordinate
- [ ] 가로 세로 좌표를 가지고 있다.
- [ ] 현재 위치의 상하좌우로 이동된 좌표를 반환할 수 있다.

### cells
- [ ] cell과 cell이 위차한 coordinate를 가지고 있다.
- [ ] 랜덤한 좌표에 지뢰를 설치할 수 있다.
- open
  - [ ] 특정 좌표를 open할 수 있다.
  - [ ] 없는 좌표를 open하려하면 예외가 발생한다.
- installMine
  - [ ] 지뢰 갯수를 받아 설치한다. 
  - [ ] 지뢰 갯수가 0개 이하면 예외가 발생한다.
  - [ ] 지뢰 갯수가 보유한 cell보다 많은 경우 예외가 발생한다.
  - [ ] 이미 지뢰가 배치된 상태면 예외가 발생한다.

### finder
- 좌표의 8방향에 위치한 좌표로 가능 방법을 들고 있다.
- coordinate의 

### 

```
높이를 입력하세요.
10

너비를 입력하세요.
10

지뢰는 몇 개인가요?
10

지뢰찾기 게임 시작
open: 1, 1
0 1 C C C C C C C C
0 1 C C C C C C C C
0 1 C C C C C C C C
1 1 C C C C C C C C
C C C C C C C C C C
C C C C C C C C C C
C C C C C C C C C C
C C C C C C C C C C
C C C C C C C C C C
C C C C C C C C C C

open: 4, 1
Lose Game.

```
