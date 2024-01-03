import {Studio} from "../../studio/model/studio";

export interface MovieDetails{

    id: string;

    title: string;

    director: string;

    publisher: string;

    yearOfPublication: string;

    studio: Studio

}
