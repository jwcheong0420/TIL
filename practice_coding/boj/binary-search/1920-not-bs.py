if __name__ == "__main__":
    input()
    _num = set(input().split()) # not binary search
    input()
    _exist = ['1' if i in _num else '0' for i in input().split()]
    print("\n".join(_exist))