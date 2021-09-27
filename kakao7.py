def solution(board, aloc, bloc):
    
    answer = 0

    _sum = []
    for i in board:
        _sum.append(sum(i))
    fin_sum = sum(_sum)

    if fin_sum % 2 == 0 : #짝수면 B가 이김 -> A는 도망다닌다
        while(movable(board, aloc[0],aloc[1], len(board))):
    else:
    
    return answer

def movable(board, x,y, edge):
    dx = [0,1,0,-1]
    dy = [-1,0,1,0]
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx >= 0 and ny >= 0 and nx < edge and ny < edge:
            if board[nx][ny] == 1 :
                return True
    return False
            



board = [[1, 1, 1], [1, 1, 1], [1, 1, 1]]
aloc = [1,0]
bloc = [1,2]
solution(board, aloc, bloc)