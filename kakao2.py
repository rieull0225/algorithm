import math

def isPrime(x):
    if x < 2:
        return False
    for i in range(2, int(math.sqrt(x)) + 1):
        if x % i == 0:
            return False 
    return True

def conversion(n, k):
    rev_base = ''
    while n > 0:
        n, mod = divmod(n, k)
        rev_base += str(mod)
    return rev_base[::-1]
    

def solution(n, k):
    count = 0
    res = conversion(n, k)
    string = str(res)
    split = string.split("0")
    for i in split:
        if i == '':
            continue
        if isPrime(int(i)) == True:
            count += 1

    return count

n = 110011
k = 10
print(solution(n , k))


