if __name__ == "__main__":
    _N = int(input())
    _num = list(map(int, input().split()))
    _num.sort()
    _M = int(input())
    _check = list(map(int, input().split()))

    for target in _check:
        left = 0
        right = _N - 1
        mid = 0
        while left <= right:
            mid = (left + right) // 2
            if _num[mid] == target:
                print(1)
                break
            elif _num[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        if left > right:
            print(0)