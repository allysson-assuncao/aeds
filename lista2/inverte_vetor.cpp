#include <iostream>
#include <vector>

using namespace std;

void invertVector(vector<int>& vet, int& numComparisons, const int left, const int right) {
    numComparisons++;
    if (left >= right) return;
    swap(vet[left], vet[right]);
    invertVector(vet, numComparisons, left + 1, right - 1);
}

int main() {
    int n;
    int numComparisons = 0;

    cout << "Digite o tamanho do vetor: " << endl;
    cin >> n;

    vector<int> vet(n);
    cout << "Digite os elementos do vetor: " << endl;
    for (int i = 0; i < n; i++) {
        cin >> vet[i];
    }

    invertVector(vet, numComparisons, 0, vet.size() - 1);

    cout << "Vetor invertido: ";
    for (const int i : vet) {
        cout << i << " ";
    }
    cout << endl;

    cout << "Numero de comparacoes: " << numComparisons << endl;

    return 0;
}
