def bs(arr, target):
    low = 0
    high = len(arr) - 1
    mid = 0
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == target:
            return 1
        elif arr[mid] > target:
            high = mid - 1
        else:
            low = mid + 1
    return 0

if __name__ == "__main__":
    _N = int(input())
    _card = list(map(int, input().split()))
    _card.sort()

    _M = int(input())
    _check = list(map(int, input().split()))

    for num in _check:
        print(bs(_card, num), end=' ')
