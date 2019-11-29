if __name__ == "__main__":
    input()
    _card = set(input().split())

    input()
    _exist = ['1' if i in _card else '0' for i in input().split()]

    print(*_exist)