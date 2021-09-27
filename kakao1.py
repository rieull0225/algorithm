def solution(id_list, report ,k):
    answer = []

    dic = {} #누가 누구를 신고했는지
    bool_dic = {} #이 사람이 정지를 당했는지
    rep_dic = {} #이 사람이 신고를 얼마나 받았는지

    set_report = list(set(report)) #중복신고 제거

    for i in id_list:
        dic[i] = 0
        rep_dic[i] = []
        bool_dic[i] = False

    for i in set_report:    
        split = []
        split = i.split(" ")#앞사람 뒷사람
        rep_dic[split[0]].append(split[1])
        dic[split[1]] += 1

    for i in dic:
        if dic[i] >= k :
            bool_dic[i] = True

    for i in id_list:
        count = 0
        for j in rep_dic[i]:
            if bool_dic[j] == True:
                count +=1
        answer.append(count)       

    return answer

#user = ["muzi", "frodo", "apeach", "neo"]
#report = ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
#k = 2

user = ["con", "ryan"]
report = ["ryan con", "ryan con", "ryan con", "ryan con"]
k = 3


print(solution(user, report, k))