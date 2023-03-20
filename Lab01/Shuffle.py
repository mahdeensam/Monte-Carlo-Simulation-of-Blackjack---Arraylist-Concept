import random

arr0 = []
for i in range(10):
    val = random.randint(0, 100)
    arr0.append(val)
    print(val)

i = 5
x = arr0[i]
print("Value at index {}: {}".format(i, x))

arr1 = arr0.copy()
arr2 = arr0

print("arr0:", arr0)
print("arr1:", arr1)
print("arr2:", arr2)

print("arr0 == arr1:", arr0 == arr1)
print("arr1 == arr2:", arr1 == arr2)
print("arr2 == arr0:", arr2 == arr0)

print("arr0.equals(arr1):", arr0 == arr1)
print("arr1.equals(arr2):", arr1 == arr2)
print("arr2.equals(arr0):", arr2 == arr0)