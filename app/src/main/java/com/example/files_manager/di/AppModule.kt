package com.example.files_manager.di

import android.app.Application
import androidx.room.Room
import com.example.compose_test.feature_files_manager.data.data_source.FileHashDatabase
import com.example.compose_test.feature_files_manager.data.repository.FileHashRepositoryImpl
import com.example.compose_test.feature_files_manager.domain.repository.FileHashRepository
import com.example.compose_test.feature_files_manager.domain.use_case.GetFilesByPath
import com.example.compose_test.feature_files_manager.domain.use_case.OrderFiles
import com.example.compose_test.feature_files_manager.domain.use_case.RunIndexingChangedFiles
import com.example.files_manager.feature_files_manager.domain.use_case.FilesManagerUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): FileHashDatabase = Room.databaseBuilder(
        app,
        FileHashDatabase::class.java,
        FileHashDatabase.DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideFilaHashRepository(db: FileHashDatabase): FileHashRepository =
        FileHashRepositoryImpl(db.fileHashDao)

    @Provides
    @Singleton
    fun provideFilesManagerUseCases(repository: FileHashRepository): FilesManagerUseCases =
        FilesManagerUseCases(
            getFilesByPath = GetFilesByPath(),
            orderingFiles = OrderFiles(),
            runIndexingChangedFiles = RunIndexingChangedFiles(repository)
        )
}