#include <iostream>
#include <vector>

using namespace std;

void selectionSort(vector<int>& vet, int& numComparisons, int& numSwaps, int index) {
    const int n = vet.size();
    if (index == n - 1) return;

    int smallestNumberIndex = index;

    for (int j = index + 1; j < n; j++) {
        numComparisons++;
        if (vet[j] < vet[smallestNumberIndex]) {
            smallestNumberIndex = j;
        }
    }

    if (smallestNumberIndex != index) {
        swap(vet[smallestNumberIndex], vet[index]);
        numSwaps++;
    }

    selectionSort(vet, numComparisons, numSwaps, index + 1);
}

int main() {
    int n, numComparisons = 0, numSwaps = 0;

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

    selectionSort(vet, numComparisons, numSwaps, 0);

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
