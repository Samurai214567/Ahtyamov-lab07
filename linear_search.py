def linear_search(arr, target):
    # Проходим весь массив слева направо
    for i, v in enumerate(arr):
        if v == target:   # нашли совпадение — возвращаем индекс
            return i
    return -1             # если не нашли — возвращаем -1

if __name__ == "__main__":
    array = [3, 5, 2, 7, 9, 1, 4]
    print(linear_search(array, 7))
