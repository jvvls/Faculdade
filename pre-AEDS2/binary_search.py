list = [0,1,2,3,4,5,6,7,8,9]

def binary_search(list, target):
    start = 0
    end = len(list)-1
    i = 0

    while start <= end :
        mid = (start + end)//2
        guess = list[mid]

        if guess == target:
            return  f"Found {mid} in {i} tries"

        
        if guess > target:
            end = mid - 1
            i += 1
            

        else:
            start = mid +1
            i += 1
            

    return None



def main():
    target = int(input("Insira valor a procurar: "))
    print(binary_search(list, target))

if __name__ == "__main__":
    main()