import androidx.room.*

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("SELECT * FROM tasks WHERE isCompleted = 0")
    suspend fun getPendingTasks(): List<Task>

    @Query("SELECT * FROM tasks WHERE isCompleted = 1")
    suspend fun getCompletedTasks(): List<Task>
}
