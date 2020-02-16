def bfs():
    queue = [_subin]

    while queue:
        current = queue.pop(0)
        if current == _brother:
            print(_time[current])
            return
        for after in (current - 1, current + 1, current * 2):
            if 0 <= after <= _MAX and not _time[after]:
                queue.append(after)
                _time[after] = _time[current] + 1

if __name__ == "__main__":
    _subin, _brother = map(int, input().split())
    _MAX = 100000
    _time = [0] * (_MAX + 1)

    bfs()