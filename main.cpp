#include <iostream>
#include <cstdlib>

void sort_ascending(int* array, int len) {
    for (int i = 0; i < len - 1; i++) {
        for (int j = 0; j < len - i - 1; j++) {
            if (array[j] > array[j + 1]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
}

int main() {
    srand(time(0));

    int array[100];

    for (int i = 0; i < 100; i++) {
        array[i] = rand() % 101;
    }

    sort_ascending(array, 100);

    std::cout << "100-elementowa posortowana rosnąco tablica z liczbami całkowitymi:" << std::endl;
    for (int i = 0; i < 100; i++) {
        std::cout << array[i] << std::endl;
    }

    return 0;
}