import {Movies} from "../../movie/model/movies";
import {Movie} from "../../movie/model/movie";

export interface StudioDetails{

    id: string

    name: string;

    owner: string;

    numberOfWorkers: number;

    yearsOfExperience: number;

    movies: Movie[];

}
