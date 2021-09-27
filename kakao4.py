from itertools import combinations_with_replacement

def solution(n, info):
    answer = []
    max = 0

    for i in combinations_with_replacement([0,1,2,3,4,5,6,7,8,9,10],n):
        sum_lion = 0
        sum_info = 0
        lion = [0 for i in range(11)]

        for j in i: lion[10 - j]+=1
        
        for j in range(len(lion)):
            if lion[j] == 0 and info[j] == 0 : continue
            if lion[j] <= info[j] :
                sum_info += (10 - j)
            else :
                sum_lion += (10 - j)

        diff = sum_lion - sum_info

        if max < diff :
            max = diff
            answer = lion
        

    if max <= 0:
        answer = [-1]
    return answer

info = [0,0,0,0,0,0,0,0,3,4,3]	
n = 10

print(solution(n,info))