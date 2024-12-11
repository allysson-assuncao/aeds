#include <iostream>
#include <vector>

using namespace std;

/*void insertionSort(vector<int>& arr, int& numComparisons) {
    int n = arr.size();
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > key) {
            numComparisons++;
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        numComparisons++;
        arr[j + 1] = key;
    }
}*/

void insertionSort(vector<int>& vet, int& numComparisons, int index1, int index2) {
    if (index2 > vet.size()) return;
    if(vet[index1] > vet[index2]) {
        swap(vet[index1], vet[index2]);
        numComparisons++;
        insertionSort(vet, numComparisons, 0,   1);
    }
    insertionSort(vet, numComparisons, index1 + 1,   index2+ 1);
}

int main() {
    int n, numComparisons = 0;

    cout << "Digite o tamanho do vetor: " << endl;
    cin >> n;

    vector<int> vet(n);
    cout << "Digite os elementos do vetor: " << endl;
    for (int i = 0; i < n; i++) {
        cin >> vet[i];
    }

    cout << "Vetor antes da ordenacao: " << endl;
    for (int i = 0; i < n; i++) {
        cout << vet[i];
        if(i != n -1) {
            cout << ", ";
        }
    }
    cout << "]" << endl;

    insertionSort(vet, numComparisons, 0, 1);

    cout << "Vetor depois da ordenacao: [";
    for (int i = 0; i < n; i++) {
        cout << vet[i];
        if(i != n -1) {
            cout << ", ";
        }
    }
    cout << "]" << endl;

    cout << "Numero de comparacoes: " << numComparisons << endl;

    return 0;
}
