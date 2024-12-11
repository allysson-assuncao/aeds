cmake_minimum_required(VERSION 3.29)
project(aeds)

set(CMAKE_CXX_STANDARD 20)

add_executable(aeds main.cpp)
add_executable(concat_vet recursive/concat_vet.cpp)
add_executable(ordenacao_insercao lista2/ordenacao_insercao.cpp)
add_executable(ordenacao_selecao lista2/ordenacao_selecao.cpp)
add_executable(merge_sort lista2/merge_sort.cpp)
add_executable(analise lista2/analise.cpp)
add_executable(find_elementos lista2/find_elementos.cpp)
