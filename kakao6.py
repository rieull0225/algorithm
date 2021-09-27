def solution(board, skill):
    answer = 0

    for i in skill:
        if i[0] == 1:
            for k in range(i[1],i[3]+1):
                for j in range(i[2], i[4]+1):
                    board[k][j] -= i[5]
        else:
            for k in range(i[1],i[3]+1):
                for j in range(i[2], i[4]+1):
                    board[k][j] += i[5]

    for i in board:
        for j in i:
            answer = answer+1 if j > 0 else answer
    return answer






board = [[1,2,3],[4,5,6],[7,8,9]]
skill = [[1,1,1,2,2,4],[1,0,0,1,1,2],[2,2,0,2,0,100]]

print(solution(board,skill))