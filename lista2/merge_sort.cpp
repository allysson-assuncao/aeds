#include <iostream>
#include <vector>

using namespace std;

void merge(vector<int>& vet, const int left, const int mid, const int right, int& numComparisons) {
    const int leftSize = mid - left + 1;
    const int rightSize = right - mid;

    vector<int> leftArray(leftSize), rightArray(rightSize);

    for (int i = 0; i < leftSize; i++)
        leftArray[i] = vet[left + i];
    for (int i = 0; i < rightSize; i++)
        rightArray[i] = vet[mid + 1 + i];

    int i = 0, j = 0, k = left;

    while (i < leftSize && j < rightSize) {
        numComparisons++;
        if (leftArray[i] <= rightArray[j]) {
            vet[k] = leftArray[i];
            i++;
        } else {
            vet[k] = rightArray[j];
            j++;
        }
        k++;
    }

    while (i < leftSize) {
        vet[k] = leftArray[i];
        i++;
        k++;
    }

    while (j < rightSize) {
        vet[k] = rightArray[j];
        j++;
        k++;
    }
}

void mergeSort(vector<int>& vet, const int left, const int right, int& numComparisons) {
    if (left >= right) return;

    const int mid = left + (right - left) / 2;

    mergeSort(vet, left, mid, numComparisons);
    mergeSort(vet, mid + 1, right, numComparisons);

    merge(vet, left, mid, right, numComparisons);
}

int main() {
    int n, numComparisons = 0;

    cout << "Digite o tamanho do vetor: ";
    cin >> n;

    vector<int> vet(n);
    cout << "Digite os elementos do vetor: " << endl;
    for (int i = 0; i < n; i++) {
        cin >> vet[i];
    }

    cout << "Vetor antes da ordenacao: [";
    for (int i = 0; i < n; i++) {
        cout << vet[i];
        if (i != n - 1) {
            cout << ", ";
        }
    }
    cout << "]" << endl;

    mergeSort(vet, 0, n - 1, numComparisons);

    cout << "Vetor depois da ordenacao: [";
    for (int i = 0; i < n; i++) {
        cout << vet[i];
        if (i != n - 1) {
            cout << ", ";
        }
    }
    cout << "]" << endl;

    cout << "Numero de comparacoes: " << numComparisons << endl;

    return 0;
}
