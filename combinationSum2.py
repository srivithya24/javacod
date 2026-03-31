class Solution:
    def combinationSum2(self, candidates, target):
        results = []
        candidates.sort() # Sorting is key to handling duplicates

        def backtrack(remain, curr_comb, start):
            if remain == 0:
                results.append(list(curr_comb))
                return
            
            for i in range(start, len(candidates)):
                # If the current number is greater than the remaining target, 
                # no need to check further (pruning)
                if candidates[i] > remain:
                    break
                
                # Skip duplicate elements at the same recursion level
                if i > start and candidates[i] == candidates[i - 1]:
                    continue
                
                curr_comb.append(candidates[i])
                # Move to 'i + 1' because each number can only be used once
                backtrack(remain - candidates[i], curr_comb, i + 1)
                curr_comb.pop()

        backtrack(target, [], 0)
        return results
