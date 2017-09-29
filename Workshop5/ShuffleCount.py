
table = dict()
import random

def test():
    for i in range(1,2401):
        nums = [1,2,3,4]
        random.shuffle(nums)
        if(str(nums) in table):
            table[str(nums)]+=1
        else:
            table[str(nums)]=1

    for i in table:
        print(i, table[i])

test()

