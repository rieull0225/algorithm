import math

def solution(fees, records):
    answer = []
    dic = {}
    fee_dic = {}
    numbers = []

    OUT_TIME = 23 * 60 + 59

    for record in records: # 0 = time, 1 = num , 2 = i/o

        keys = record.split()
        time = keys[0].split(":")
        time_m = int(time[0]) * 60 + int(time[1])
        if keys[1] in dic:
            dic[keys[1]].append(time_m)
        else :
            dic[keys[1]] = [time_m]
            fee_dic[keys[1]] = 0
            numbers.append(keys[1])
            [300, 350, 360 , out_time]


    for key in dic:
        sum_time = 0
        if len(dic[key]) % 2 == 1:
            dic[key].append(OUT_TIME)

        for i in range(1,len(dic[key]),2):
            sum_time += dic[key][i] - dic[key][i-1]
        if sum_time < fees[0]:
            fee_dic[key] = fees[1]
        else : 
            fee_dic[key] = fees[1] + math.ceil((sum_time - fees[0]) / fees[2]) * fees[3] 

        
    numbers.sort()
    for key in numbers:
        answer.append(int(fee_dic[key]))
    
    return answer
