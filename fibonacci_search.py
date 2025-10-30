def fibonacci_search(arr, x):
    n = len(arr)
    # Инициализируем числа Фибоначчи F(m-2)=0, F(m-1)=1, F(m)=1
    fm2, fm1 = 0, 1
    fm = fm2 + fm1

    # Находим минимальное F(m) >= n
    while fm < n:
        fm2, fm1 = fm1, fm
        fm = fm2 + fm1

    offset = -1  # смещение удалённой части массива
    # Пока есть элементы для проверки
    while fm > 1:
        # Проверяем позицию i = min(offset + F(m-2), n-1)
        i = min(offset + fm2, n - 1)
        if arr[i] < x:
            # Сдвигаем окно вправо
            fm, fm1, fm2 = fm1, fm2, fm - fm1
            offset = i
        elif arr[i] > x:
            # Сдвигаем окно влево
            fm, fm1, fm2 = fm2, fm1 - fm2, fm - (fm1 - fm2)
        else:
            return i

    # Проверяем последний возможный элемент
    if fm1 and offset + 1 < n and arr[offset + 1] == x:
        return offset + 1
    return -1

if __name__ == "__main__":
    arr = [10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100]
    print(fibonacci_search(arr, 85))
