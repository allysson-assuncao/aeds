import pandas as pd
import matplotlib.pyplot as plt

# Load the CSV file into a DataFrame
df = pd.read_csv('sort_results.csv')

# Plot the results
plt.figure(figsize=(10, 6))
for algorithm in df['Algorithm'].unique():
    subset = df[df['Algorithm'] == algorithm]
    for order in subset['Order'].unique():
        order_subset = subset[subset['Order'] == order]
        plt.plot(order_subset['Size'], order_subset['Time (ms)'], label=f'{algorithm} - {order}')

plt.title('Sorting Algorithm Performance')
plt.xlabel('Array Size')
plt.ylabel('Time (ms)')
plt.legend()
plt.grid(True)
plt.savefig('sorting_performance.png')
plt.show()

# def process_csv(file_path):
#     df = pd.read_csv(file_path)
#     df['Test Section'] = (df.index // (len(df) // 5)) + 1
#     averages = df.groupby(['Algorithm', 'Size', 'Order', 'Test Section']).mean().reset_index()
#
#     return averages
#
# def plot_averages(averages):
#     for algorithm in averages['Algorithm'].unique():
#         algo_data = averages[averages['Algorithm'] == algorithm]
#         plt.figure(figsize=(10, 6))
#         for order in algo_data['Order'].unique():
#             order_data = algo_data[algo_data['Order'] == order]
#             plt.plot(order_data['Size'], order_data['Time (ms)'], label=f'{order} order')
#
#         plt.title(f'Average Time for {algorithm}')
#         plt.xlabel('Size')
#         plt.ylabel('Time (ms)')
#         plt.legend()
#         plt.grid(True)
#         plt.show()
#
# if __name__ == "__main__":
#     file_path = 'sort_results.csv'
#     averages = process_csv(file_path)
#     plot_averages(averages)
