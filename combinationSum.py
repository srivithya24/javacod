class Solution:
    def combinationSum(self, candidates, target):
        results = []

        def backtrack(remain, curr_comb, start):
            if remain == 0:
                results.append(list(curr_comb))
                return
            elif remain < 0:
                return

            for i in range(start, len(candidates)):
                curr_comb.append(candidates[i])
                backtrack(remain - candidates[i], curr_comb, i)
                curr_comb.pop()

        backtrack(target, [], 0)
        return results
